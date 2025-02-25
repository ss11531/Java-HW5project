# Java-HW5project
## Java訂單管理系統
### 專案說明
這是一個MVC設計的訂單管理系統，使用Java（JFrame）作為前端 UI，後端則採用 MySQL進行數據存儲與管理。系統主要涵蓋 DAO 層 和 Service 層，確保良好的模組化設計，以提升可維護性與擴展性。
- ✔ MVC 架構 —— 清晰的分層設計，提升程式可讀性與維護性
- ✔ MySQL 數據庫 —— 提供高效、安全的數據存取與管理
- ✔ JFrame UI —— 直覺易用的桌面應用介面
- ✔ 客戶登入功能 —— 使用者可透過帳號密碼登入，查詢個人訂單狀態
- ✔ 訂單管理 —— 支援修改、刪除與查詢訂單

---

### 目錄結構
```HW5/src
├─controller
│  ├─consumer
│      ├─AddCoErrorUI.java
│      ├─AddCoSuccessUI.java
│      ├─AddCoUI.java
│      ├─LoginCoErrorUI.java
│      ├─LoginCoSuccessUI.java
│      ├─LoginCoUI.java
│  ├─member
│      ├─AddEmErrorUI.java
│      ├─AddEmSuccessUI.java
│      ├─AddEmUI.java
│      ├─LoginEmErrorUI.java
│      ├─LoginEmSuccessUI.java
│      ├─LoginEmUI.java
│  ├─porder
│      ├─AddPorderUI.java
│      ├─PorderMainUI.java
│      ├─PorderManagerUI.java
│  ├─product
│      ├─ProductUI.java
├─dao
│  │─ConsumerDao.java
│  ├─MemberDao.java
│  ├─PorderDao.java
│  ├─ProductDao.java
│  └─impl
│      ├─ConsumerDaoImpl.java
│      ├─MemberDaoImpl.java
│      ├─PorderDaoImpl.java
│      ├─ProductDaoImpl.java
├─model
│  │─Cnsumer.java
│  │─Member.java
│  │─Porder.java
│  │─Product.java
├─service
│  │─CnsumerService.java
│  │─MemberService.java
│  │─PorderService.java
│  │─ProductService.java
│  └─impl
│      ├─CnsumerServiceImpl.java
│      ├─MemberServiceImpl.java
│      ├─PorderServiceImpl.java
│      ├─ProductServiceImpl.java
└─util
   │─DbConnection.java
   │─Tool.java
```
---
### src 目錄檔案說明
#### **controller/consumer**(客戶相關 UI)
- `AddCoErrorUI.java` - 顯示客戶新增失敗的錯誤提示介面。
- `AddCoSuccessUI.java` - 顯示客戶成功新增的確認介面。
- `AddCoUI.java` - 用於客戶註冊/新增的 UI 介面。
- `LoginCoErrorUI.java` - 顯示客戶登入失敗的錯誤提示介面。
- `LoginCoSuccessUI.java` - 顯示客戶登入成功的確認介面。
- `LoginCoUI.java` - `客戶登入介面。`

#### **controller/member**(員工相關 UI)
- `AddEmErrorUI.java` - 顯示員工新增失敗的錯誤提示介面。
- `AddEmSuccessUI.java` - 顯示員工成功新增的確認介面。
- `AddEmUI.java` - 用於員工註冊/新增的 UI 介面。
- `LoginEmErrorUI.java` - 顯示員工登入失敗的錯誤提示介面。
- `LoginEmSuccessUI.java` - 顯示員工登入成功的確認介面。
- `LoginEmUI.java` - 員工登入介面。

#### **controller/porder**(訂單相關 UI)
- `AddPorderUI.java` - 訂單新增介面。
- `PorderMainUI.java` - 訂單管理的主介面，可查看訂單狀態。
- `PorderManagerUI.java` - 訂單管理介面，用於訂單處理與修改。

#### **controller/product**(服務相關 UI))
- `ProductUI.java` - 服務 (商品) 管理介面，可查看服務列表。
  
#### src/dao/ DAO層，負責與資料庫進行交互，定義基本的 CRUD 操作
- `ConsumerDao.java` - 定義客戶的資料存取介面。
- `MemberDao.java` - 定義員工的資料存取介面。
- `PorderDao.java` - 定義訂單的資料存取介面。
- `ProductDao.java` - 定義服務 (商品) 的資料存取介面。

#### dao/impl/ DAO實作類別
- `ConsumerDaoImpl.java` - 客戶 DAO 介面的具體實作。
- `MemberDaoImpl.java` - 員工 DAO 介面的具體實作。
- `PorderDaoImpl.java` - 訂單 DAO 介面的具體實作。
- `ProductDaoImpl.java` - 服務 DAO 介面的具體實作。

#### src/model/ Model負責定義應用程式結構
- `Consumer.java` - 客戶數據模型。
- `Member.java` - 員工數據模型。
- `Porder.java` - 訂單數據模型。
- `Product.java` - 服務 (商品) 數據模型。

#### src/service/ Service層，負責執行邏輯處理，通常調用DAO層來處理資料
- `ConsumerService.java` - 客戶的業務邏輯介面。
- `MemberService.java` - 員工的業務邏輯介面。
- `PorderService.java` - 訂單的業務邏輯介面。
- `ProductService.java` - 服務 (商品) 的業務邏輯介面。

#### service/impl/ Service實作類別
- `ConsumerServiceImpl.java` - 客戶業務邏輯的具體實作。
- `MemberServiceImpl.java` - 員工業務邏輯的具體實作。
- `PorderServiceImpl.java` - 訂單業務邏輯的具體實作。
- `ProductServiceImpl.java` - 服務 (商品) 業務邏輯的具體實作。

#### src/util/工具類別與通用功能
- `DbConnection.java`-管理資料庫的連線。
- `Tool.java `-通用工具類別輔助函數。
---
### 使用畫面

#### 員工登入畫面
![員工登入畫面](https://raw.githubusercontent.com/ss11531/Java-HW5project/main/photo/Login.png)
#### 員工管理畫面
![員工管理畫面](https://raw.githubusercontent.com/ss11531/Java-HW5project/main/photo/Product.png)
#### 客人登入畫面
![客人登入畫面](https://raw.githubusercontent.com/ss11531/Java-HW5project/main/photo/LoginCo.png)
#### 客人訂單管理畫面
![客人訂單管理畫面](https://raw.githubusercontent.com/ss11531/Java-HW5project/main/photo/PorderMain.png)
#### 客人新增畫面
![客人新增畫面](https://raw.githubusercontent.com/ss11531/Java-HW5project/main/photo/AddPorder.png)
#### 客人訂單管理畫面
![客人訂單管理畫面](https://raw.githubusercontent.com/ss11531/Java-HW5project/main/photo/PorderManager.png)
