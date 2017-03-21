# UDP Client Serever Application

sends some data from client to the server, where the computation is done and the
result is sent back to the client.

This type of applications is commonly used in Distributed Systems.

## Details

1. A client program called _UDPClient.java_ and a server program called _UDPServer.java_
2. The _server program_ continuously check if there are any client requests, and
handles them.
3. The client program’s main method takes two arguments
_(destination server IP/hostname and destination server port)_ and these arguments
 are not statically wired in the program itself. The client’s program uses those
arguments later to connect to the server.
4. User inputs an UpperCase word  (one at a time) dynamically (not stored in the program).
5. The _client program_ sends the word to the server, the _server program_ then
 change it from the UpperCase to the LowerCase and sends the result back to the client.

## Notes

This Program made based on the first assignment in the Distributed Systems course at college.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
