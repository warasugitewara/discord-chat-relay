# 🎉 Discord Chat Relay v1.0.0 - 初版リリース

## 📢 概要

Discord Chat Relay v1.0.0 をリリースしました！

Minecraft 1.21.10 Quilt で、ゲーム内チャットメッセージを Discord に自動リレーします。

---

## ✨ 主な機能

### 🔵 チャット自動リレー
- プレイヤーチャットとシステムメッセージを自動的に Discord に送信
- メッセージは 2000 文字で自動カット

### ⚙️ ModMenu GUI
- **Bot Token** - Discord Bot トークンを安全に設定
- **Channel ID** - リレー先チャンネルを指定
- **Enabled** - MOD のオン/オフを切り替え

### 📊 BetterF3 統合
F3 キーで表示される画面に以下を表示：
- 接続状態（Connected/Connecting.../Disabled）
- 設定済み Channel ID

### 🔄 自動再接続
Discord との接続が切れた場合、自動的に再接続を試みます（30秒間隔）

### 🛡️ セキュア設定
- トークンはローカル JSON ファイルに保存
- ファイルは `%APPDATA%\.minecraft\config\discord-chat-relay-config.json`

---

## 📦 ファイル

### 構成
- `discord-chat-relay-1.0.0.jar` - MOD 本体

### サポート OS
- Windows 10/11
- macOS（テスト環境なし）
- Linux（テスト環境なし）

### 必須環境
- Minecraft 1.21.10
- Quilt Loader 0.27.1 以上
- Java 21 以上

### オプション MOD
- **ModMenu** - GUI でのコンフィグ（推奨）
- **Cloth Config** - ModMenu の UI（推奨）
- **BetterF3** - F3 画面拡張（オプション）

---

## 🚀 クイックスタート

### インストール
1. `discord-chat-relay-1.0.0.jar` を `%APPDATA%\.minecraft\mods\` にコピー
2. Minecraft を起動（Quilt Loader）

### 設定
1. Minecraft メインメニュー → **MOD** ボタン
2. **Discord Chat Relay** を検索 → **Config** をクリック
3. 以下を入力：
   - **Bot Token**: Discord Bot のトークン
   - **Channel ID**: メッセージを送信するチャンネルの ID
   - **Enabled**: ON にする
4. 保存

### 実行
```
ワールドにログイン → Discord チャンネルにメッセージがリレーされます
```

---

## 🔧 Discord Bot セットアップ

### ステップ 1: Bot 作成
1. [Discord Developer Portal](https://discord.com/developers/applications) にアクセス
2. **New Application** をクリック
3. BOT タブで **Add Bot** をクリック

### ステップ 2: 権限設定
1. **TOKEN** をコピー（MOD で使用）
2. **Intents** で以下を有効化：
   - Message Content Intent ✅
   - (オプション) Server Members Intent
   - (オプション) Presence Intent

### ステップ 3: サーバーに招待
1. **OAuth2** > **URL Generator** へ
2. Scopes: `bot` を選択
3. Permissions: `Send Messages` を選択
4. 生成された URL でサーバーに Bot を招待

### ステップ 4: Channel ID 取得
1. Discord で対象チャンネルを右クリック
2. **チャンネル ID をコピー** を選択

---

## 📋 既知の制限事項

- 日本語の絵文字は完全にサポートされていない場合があります
- BOT のメッセージ送信が多い場合、レート制限に引っかかる可能性があります
- BetterF3 なしの場合、F3 画面の拡張表示は機能しません

---

## 🐛 バグ報告

問題が発生した場合は、以下を含めて [GitHub Issues](https://github.com/warasugitewara/discord-chat-relay/issues) で報告してください：

- Minecraft バージョン
- Quilt Loader バージョン
- エラーメッセージ
- 再現手順

---

## 📄 ライセンス

MIT License

---

## 🙏 謝辞

- Quilt プロジェクト
- Discord4J
- Minecraft コミュニティ

---

**Happy chatting! 🎮💬**

🔗 [GitHub リポジトリ](https://github.com/warasugitewara/discord-chat-relay)
