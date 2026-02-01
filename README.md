# Discord Chat Relay Mod

Quilt 1.21.10向けのClient側modで、Minecraftのすべてのチャットメッセージ（プレイヤーの発言とシステムメッセージ）をDiscord botを通じてテキストチャンネルに自動的に送信します。

## 機能

- ✅ MinecraftのすべてのチャットメッセージをDiscordに送信
- ✅ ModMenuから簡単に設定可能（Bot Token、Channel ID、ON/OFF）
- ✅ ゲーム内の設定GUIで管理（Cloth Config対応）
- ✅ 設定は`config/discord-chat-relay.json`に自動保存
- ✅ 非同期処理でゲームパフォーマンスに影響なし
- ✅ 自動再接続機能
- ✅ BetterF3統合（F3画面にmod状態を3行表示）

## インストール

### 前提条件
- Minecraft 1.21.10
- Quilt Loader（0.27.0以上）
- ModMenu（オプション、推奨）
- Cloth Config（ModMenuと一緒に使用）
- BetterF3（オプション、HUD表示用）

## インストール

### 前提条件
- Minecraft 1.21.10
- Quilt Loader（0.27.0以上）
- **VSCode** + **Java Extension Pack**（ビルド用）

### インストール手順

1. `discord-chat-relay-1.0.0.jar`をModsフォルダにコピー
2. Minecraftを起動
3. ModMenuのDiscord Chat Relayを開いて設定

## ビルド（開発者向け）

### 最も簡単: VSCode

```powershell
# プロジェクトを開く
cd C:\Users\waras\Workspace\DiscordChatRelay
code .

# VSCodeで Ctrl+Shift+B を押す
```

詳細は [VSCODE_QUICK.md](VSCODE_QUICK.md) を参照

### コマンドラインビルド

```bash
# Windows
cd C:\Users\waras\Workspace\DiscordChatRelay
.\gradlew.bat build

# Mac/Linux
./gradlew build
```

## Discord Bot の準備

### 1. Discord Developer Portalでアプリケーションを作成
- https://discord.com/developers/applications にアクセス
- "New Application"をクリック
- 名前を入力（例: "Minecraft Chat Relay"）
- "Create"

### 2. Bot を作成
- "Bot"タブを開く
- "Add Bot"をクリック
- "TOKEN"をコピー（ModMenuで使用）

### 3. 権限を設定
- "Bot Permissions"セクションで以下を有効化:
  - `Send Messages`
  - `Read Message History`

### 4. Serverに招待
- "OAuth2" → "URL Generator"を開く
- Scopesで`bot`を選択
- Permissionsで`Send Messages`を選択
- 生成されたURLでBotをServerに招待

### 5. Channel IDを取得
- Discordで右クリック → "Copy Channel ID"（Developer Modeが必要）
- Developer Mode: ユーザー設定 → "App Settings" → "Advanced" → "Developer Mode"をON

## 使用方法

1. Minecraftを起動
2. Esc → "Options" → "ModMenu" → "Discord Chat Relay"
3. 設定:
   - **Bot Token**: Discord Developer Portalで取得したToken
   - **Channel ID**: メッセージ送信先のDiscordチャンネルID
   - **Enabled**: トグルをONにして有効化
4. ゲーム内でチャットするとDiscordに自動送信

### BetterF3でのステータス表示

BetterF3をインストールすると、F3キーを押すとmod情報が表示されます：

```
--- Discord Chat Relay ---
Status: Connected
Channel: (last 5 digits)
```

- Status: `Connected`=接続済み、`Connecting...`=接続中、`Disabled`=無効
- Channel: チャンネルIDの下5桁を表示

## トラブルシューティング

### メッセージが送信されない
- EnabledがONになっているか確認
- Bot Tokenが正しいか確認
- Channel IDが正しいか確認（数字のみ）
- BotがChannelにアクセス権限があるか確認（サーバー → チャンネル → 権限を確認）

### 接続エラー
- コンソールでエラーメッセージを確認
- 30秒待つと自動再接続します
- Token/Channel IDを再度確認

## 設定ファイル

設定は`%APPDATA%\.minecraft\config\discord-chat-relay.json`に保存されます：

```json
{
  "botToken": "YOUR_BOT_TOKEN_HERE",
  "channelId": "YOUR_CHANNEL_ID_HERE",
  "enabled": true
}
```

## ライセンス

MIT License

## サポート

問題が発生した場合は、コンソールログを確認してください。ModはBugtracker等で報告できます。

## 変更履歴

### v1.0.0
- 初期リリース
- チャットメッセージの送信機能
- ModMenuの設定画面
- BetterF3統合（F3画面にステータス表示）
