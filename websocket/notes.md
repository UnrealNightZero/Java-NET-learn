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
>Message
```java=
//發
OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream()); //將資料寫入socket的輸出流
writer.write(scanner.nextLine()+"\n"); //讀取下一行輸入
writer.flush(); //強制緩衝區資料寫入socket 不等緩衝區滿
//收
BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //將socket的輸出流資料寫入緩衝區讀取
System.out.println(reader.readLine()); //從輸入流中讀取一行資料
```
>File
```
//收
InputStream stream = socket.getInputStream(); //使用socket取得輸入流
FileOutputStream fileOutputStream = new FileOutputStream("net/data.txt"); //將資料寫入到文件(限8-bit 的 bytes)
byte[] bytes = new byte[1024]; //暫存寫入資料
int i; //保存每次從输入流中讀取的位元組
while ((i = stream.read(bytes)) != -1){ //讀取輸入流中的資料，直到讀取到文件尾
  fileOutputStream.write(bytes,0,i); //輸入流中讀取到的資料寫入到文件
}
fileOutputStream.flush(); //確保所有的資料都被寫入到文件中。
fileOutputStream.close(); //關閉了文件輸出流，釋放資源。
//傳
FileInputStream fileInputStream = new FileInputStream("test.txt"); //讀取文件寫入
OutputStream stream = socket.getOutputStream();(限8-bit 的 bytes)
byte[] bytes = new byte[1024];//存放從文件中讀取的數據
int i; //保存每次從文件中讀取的位元組
while ((i = fileInputStream.read(bytes)) != -1){ //讀取文件的資料，直到讀取到文件尾
  stream.write(bytes,0,i); //bytes 中从索引 0 到索引 i-1 的資料寫入到输出流中 送出給server
}
fileInputStream.close(); //關閉文件輸入流
stream.flush(); //確保所有的資料都被發送给客户端
```
