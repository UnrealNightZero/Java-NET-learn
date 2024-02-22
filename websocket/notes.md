# Server讓Client溝通
## 連接狀態
>Server
```java=
ServerSocket server = new ServerSocket(port) //新增監聽port
Socket socket  = server.accept();  //等待連接(堵塞線程)
socket.setSoTimeout(3000);// 設定超時時間,單位ms
```
>Client
```java=
Socket socket = new Socket("",port) //設定連線Url,port
socket.setKeepAlive(true);  // TCP 連接的保持活動功能,預設關閉
socket.close(); //關閉連線
```
