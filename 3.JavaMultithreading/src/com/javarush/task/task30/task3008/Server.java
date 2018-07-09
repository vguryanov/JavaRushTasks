package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by User2 on 06.03.2017.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Сообщение не отправлено");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            ConsoleHelper.writeMessage("Установленно соединение с адресом " + socket.getRemoteSocketAddress());
            String clientName = null;
            //Создаем Connection
            try (Connection connection = new Connection(socket)) {
                //Выводить сообщение, что установлено новое соединение с удаленным адресом
                ConsoleHelper.writeMessage("Подключение к порту: " + connection.getRemoteSocketAddress());
                //Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента
                clientName = serverHandshake(connection);
                //Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED)
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                //Сообщать новому участнику о существующих участниках
                sendListOfUsers(connection, clientName);
                //Запускать главный цикл обработки сообщений сервером
                serverMainLoop(connection, clientName);

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");
            } finally {
                if (clientName != null) {
                    //После того как все исключения обработаны, удаляем запись из connectionMap
                    connectionMap.remove(clientName);
                    //и отправлялем сообщение остальным пользователям
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));

                    ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
                }
            }

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();

                if (answer.getType() == MessageType.USER_NAME) {
                    if (!answer.getData().isEmpty()) {
                        if (!connectionMap.containsKey(answer.getData())) {

                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return answer.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals(userName)) connection.send(new Message(MessageType.USER_ADDED, name));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message inMessage = connection.receive();

                if (inMessage.getType() == MessageType.TEXT)
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + inMessage.getData()));
                else ConsoleHelper.writeMessage("Error, bitch");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int serverPort = ConsoleHelper.readInt();
        ServerSocket serverSocket = new ServerSocket(serverPort);

        try {
            ConsoleHelper.writeMessage("Сервер запущен");

            while (true) {
                //Слушаем
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                //запускаем handler
                handler.start();
            }
        } catch (IOException e) {
            serverSocket.close();
            e.printStackTrace();
        }
    }
}
