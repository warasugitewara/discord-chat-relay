# Discord Chat Relay Mod - 開発ガイド

## 開発環境のセットアップ

### 前提条件
- Java 25（C:\Program Files\java\graalvm-jdk-25.0.1+8.1）
- Git
- VSCode（推奨）またはコマンドライン

### ステップ1: リポジトリをクローン

```bash
git clone <repository-url>
cd DiscordChatRelay
```

### ステップ2: 方法A - VSCodeで開く（推奨）

1. VSCodeを起動
2. `File → Open Folder` → `DiscordChatRelay` フォルダ選択
3. VSCodeが自動的にJava環境を認識します
4. Extension Packをインストール推奨：
   - Extension Pack for Java
   - Gradle for Java

### ステップ3: 方法B - コマンドラインでビルド

#### Windows
```bash
cd C:\Users\waras\Workspace\DiscordChatRelay
build.bat build
```

#### Linux/Mac
```bash
cd ~/DiscordChatRelay
./build.sh build
```

## ビルドコマンド

### Windows
```bash
# 単純なビルド
build.bat build

# 既存ファイルをクリアしてビルド
build.bat clean build

# ビルドツールをクリア
build.bat clean
```

### Linux/Mac/PowerShell
```bash
# 単純なビルド
./gradlew build

# 既存ファイルをクリアしてビルド
./gradlew clean build

# ビルドツールをクリア
./gradlew clean
```

## ビルド出力

成功時：
```
build/libs/discord-chat-relay-1.0.0.jar
```

## VSCodeでの開発

### タスク実行
1. `Ctrl+Shift+B` → "Gradle: build" を選択
2. または、`Ctrl+Shift+P` → "Tasks: Run Task" → "Gradle: ..."

### デバッグ
- Java Language Serverが自動的にクラスを解析します
- エラーのあるコードは波線で表示されます
- `Ctrl+Click` でクラス定義へジャンプ

## トラブルシューティング

### Gradleダウンロードエラー
- インターネット接続を確認してください
- プロキシを使用している場合は `gradle.properties` を編集してください

### ビルドエラー
```bash
build.bat clean build
```

で依存関係を再度ダウンロードしてください。

### Java バージョンエラー
Java 25 がインストールされていることを確認：
```bash
C:\Program Files\java\graalvm-jdk-25.0.1+8.1\bin\java -version
```
