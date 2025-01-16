# Java-NET-learn
簡單實現了WebSocket的實作
# WebSocket 範例 (Java)

此專案展示了使用 Java Sockets 實現類似 WebSocket 的簡單通訊，包含一個 **伺服器** 和一個 **客戶端**，實現基本的消息交換。

## 功能特性
- 伺服器監聽 `8080` 端口上的客戶端連接。
- 客戶端向伺服器發送消息。
- 伺服器接收並處理消息，然後回應客戶端。

## 前置需求
- Java 開發工具包 (JDK) 8 或更高版本。
- 終端機或支援 Java 的 IDE。

## 檔案結構
- `Server.java`: 實現伺服器邏輯。
- `Client.java`: 實現客戶端邏輯。

## 安裝與執行

### 步驟 1: 編譯 Java 檔案
```bash
javac Server.java Client.java
```

### 步驟 2: 啟動伺服器
在一個終端機中，啟動伺服器：
```bash
java Server
```
伺服器將等待客戶端連接。

### 步驟 3: 啟動客戶端
在另一個終端機中，啟動客戶端：
```bash
java Client
```
客戶端將連接到伺服器，發送消息並顯示伺服器的回應。

## 工作流程
1. **伺服器**：
   - 在 `8080` 端口上監聽進入的連接。
   - 接受連接並讀取客戶端的消息。
   - 回應客戶端。

2. **客戶端**：
   - 連接到 `localhost:8080` 的伺服器。
   - 發送用戶輸入的消息。
   - 顯示伺服器的回應。

## 範例輸出

### 伺服器：
```plaintext
等待連接...
客戶端連接成功，IP:127.0.0.1
等待客戶端數據...
收到客戶端數據: Hello, Server!
```

### 客戶端：
```plaintext
connect server
Hello, Server!
data send!wait for server check...
receive server data: 已收到數據：Hello, Server!
```

## 注意事項
- 確保伺服器在啟動客戶端之前運行。
- 伺服器和客戶端設置為通過 `localhost` 通訊。

