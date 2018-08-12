# Read File Over Network Onto Screen

Correctly complete the following assignment.  Follow all directions. The final two `.java` files - server and client, and a separate output of the `hvccconsole.txt` text file of the file read over the network (copied and pasted from the client console window showing the the console's input and the listing of the contents of `hvcc.txt`) should be submitted. The `hvcc.txt` file should be in the project folder of the server.

You can use the same computer, but either way we are simulating over a network so the server can use the local host but the client must use the server's name. You can print this name from the server and then the client should input that name and use the `getByName()` method. Again, if you use the same computer, use `getLocalHost() `for the server only. Use the `getByName()` with the server host name for the client (as described in last weeks overview).

If needed, the console can be made bigger for viewing the `hvcc.txt` file by right clicking and changing the properties, or if using a separate console window it can be made bigger for viewing the `hvcc.txt` file by right clicking on the title bar of the console window and going to properties and the font and layout tabs. Copy and paste into a new plain text file (it can be in Eclipse). Submit - `server.java`, `client.java`, and the console output from the client (which will be the client's input and the output of the server's `hvcc.txt` file displayed on the client console window). If using the same computer for both server and client, the consoles can be switched in Eclipse - lower right corner.