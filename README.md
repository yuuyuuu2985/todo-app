# Todo API

Spring Boot + MySQL で作成したREST API

## 使用技術

- Java 17
- Spring Boot 4.1.0
- MySQL 9.6
- JPA / HIdenate
- JUnit 5
- GitHub Actions

## 機能

| メソッド | エンドポイント | 説明 |
| --- | --- | --- |
| GET | /todos | 一覧取得 |
| GET | /todos/{id} | 一件取得 |
| POST | /todos/ | 追加 |
| PUT | /todos/{id} | 更新 |
| DELETE | /todos/{id} | 削除 |

## 起動方法

```bash
# MySQLを起動
brew services start mysql

#サーバー起動
cd todo
./mvnw spring-boot:run
```

## テスト実行

```bash
./mvnw test
```