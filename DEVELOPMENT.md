# Discord Chat Relay Mod - 開発ガイド

## 開発環境のセットアップ

### 前提条件
- Java 21以上
- Git

### ステップ1: リポジトリをクローン

```bash
git clone <repository-url>
cd DiscordChatRelay
```

### ステップ2: プロジェクトをセットアップ

#### オプションA: IntelliJ IDEAで開く（推奨）

1. IntelliJ IDEAを起動
2. "Open Project" → プロジェクトフォルダを選択
3. IDEAが自動的にGradleプロジェクトを認識してセットアップします
4. "Gradle" パネルを開いて `build` タスクを実行

#### オプションB: VSCodeで開く

1. VSCodeを起動
2. フォルダを開く
3. `build.gradle` を開く
4. 推奨される拡張機能をインストール
5. ターミナルで `./gradlew build` を実行

### ステップ3: 開発サーバーの起動

```bash
./gradlew runClient
```

## ビルド

```bash
./gradlew build
```

成功すると、`build/libs/discord-chat-relay-1.0.0.jar` が生成されます。

## トラブルシューティング

### Gradleがダウンロードできない

Gradleが自動的にダウンロードされます。インターネット接続を確認してください。

### ビルドエラーが発生する

```bash
./gradlew clean build
```

で依存関係を再度ダウンロードしてください。

### Discord4Jのコンパイルエラー

プロジェクトをリロードしてください（IDEAでは `File → Invalidate Caches → Invalidate and Restart`）。
