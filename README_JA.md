# 🎮 Discord Chat Relay

**Minecraft 1.21.10 Quilt クライアント側 MOD**

ゲーム内チャットメッセージを Discord に自動リレーします。

---

## ✨ 機能

- ✅ **チャット自動リレー** - プレイヤーメッセージとシステムメッセージを Discord に送信
- ⚙️ **ModMenu統合** - GUI でトークンと Channel ID を設定
- 📊 **BetterF3統合** - F3 画面に接続状態を表示
- 🔄 **自動再接続** - Discord 接続の切断時に自動的に再接続
- 🛡️ **セキュア** - トークンはローカル設定ファイルに保存

---

## 📥 インストール

### 前提条件
- **Minecraft 1.21.10**
- **Quilt Loader** インストール済み
- **Discord Bot** 作成済み

### セットアップ手順

#### 1️⃣ Discord Bot を作成
1. [Discord Developer Portal](https://discord.com/developers/applications) にアクセス
2. **New Application** をクリック
3. アプリケーション名を入力（例：Discord Chat Relay）
4. **Bot** タブから **Add Bot** をクリック
5. **TOKEN** をコピー（後で使用）
6. **Message Content Intent** を有効化
   - **PRESENCE INTENT**, **SERVER MEMBERS INTENT** も有効化推奨
7. **OAuth2** > **URL Generator** で以下スコープを選択：
   - `bot`
   - `send-messages`
   - `read-message-history`
8. 生成された URL でサーバーに Bot を招待

#### 2️⃣ Channel ID を取得
1. Discord サーバーで、Bot がメッセージを送信するチャンネルを右クリック
2. **チャンネル ID をコピー** を選択

#### 3️⃣ MOD をインストール
1. MOD JAR をダウンロード → `%APPDATA%\.minecraft\mods\` にコピー
2. Minecraft を起動（Quilt で起動）

#### 4️⃣ MOD を設定
1. Minecraft のメインメニューで **MOD** ボタンをクリック
2. **Discord Chat Relay** を検索
3. **Config** をクリック
4. 以下を入力：
   - **Bot Token**: コピーしたトークン
   - **Channel ID**: 取得した Channel ID
   - **Enabled**: ON にする
5. 保存して完了

---

## 🚀 使用方法

### 起動
```
1. Minecraft を起動（Quilt Loader）
2. ワールドにログイン
3. Discord に自動的にチャットがリレーされます
```

### ステータス確認
```
F3 キーを押す → BetterF3 HUD に接続状態が表示されます
- 🟢 Connected - Discord に接続中
- 🔴 Connecting... - 接続試行中
- ⚪ Disabled - MOD が無効
```

### トラブルシューティング

| 問題 | 原因 | 解決策 |
|------|------|--------|
| チャットが送信されない | Token が無効 | ModMenu で Token を確認 |
| チャットが送信されない | Channel ID が無効 | ModMenu で Channel ID を確認 |
| Bot がメッセージを受け取れない | Bot に権限がない | サーバー設定で Bot 権限を確認 |
| F3 に表示されない | BetterF3 がない | BetterF3 MOD を別途インストール |

---

## 🛠️ 開発

### ビルド方法

**前提条件:**
- Java 21 以上
- Gradle 8.8 以上

**コマンド:**
```bash
# リポジトリをクローン
git clone https://github.com/warasugitewara/discord-chat-relay.git
cd discord-chat-relay

# ビルド実行
./gradlew build
```

**出力:**
```
build/libs/discord-chat-relay-1.0.0.jar
```

### 依存関係
- **Quilt Loader** - MOD ローダー
- **Quilt Standard Libraries** - Quilt API
- **Discord4J** - Discord ボット API
- **Reactor** - リアクティブ処理
- **ModMenu** - コンフィグ GUI（オプション）
- **Cloth Config** - コンフィグ画面（オプション）
- **BetterF3** - F3 表示拡張（オプション）

---

## 📝 ファイル構成

```
discord-chat-relay/
├── src/main/java/com/github/waras/discordchatrelay/
│   ├── DiscordChatRelayMod.java           # MOD エントリポイント
│   ├── config/ModConfig.java              # 設定管理
│   ├── discord/DiscordBot.java            # Discord 統合
│   ├── listener/ChatListener.java         # チャット監視
│   ├── screen/ModMenuConfigScreen.java    # MOD Menu 画面
│   └── hud/DiscordChatRelayHudProvider.java # BetterF3 統合
├── src/main/resources/
│   ├── quilt.mod.json                     # MOD メタデータ
│   └── discord-chat-relay.mixins.json     # Mixin 設定
├── build.gradle                           # Gradle ビルド設定
└── gradle.properties                      # ビルドプロパティ
```

---

## 📊 設定ファイル

設定は JSON 形式で保存されます：

```
%APPDATA%\.minecraft\config\discord-chat-relay-config.json
```

**例:**
```json
{
  "enabled": true,
  "bot_token": "YOUR_DISCORD_BOT_TOKEN_HERE",
  "channel_id": "123456789012345678"
}
```

---

## ⚠️ セキュリティに関する注意

- **Bot Token を絶対に公開しないでください**
- 設定ファイルはローカルマシンにのみ保存されます
- GitHub などに Token をコミットしないよう注意してください

---

## 📄 ライセンス

MIT License - 詳細は [LICENSE](./LICENSE) を参照

---

## 🤝 貢献

改善提案やバグ報告は [Issues](https://github.com/warasugitewara/discord-chat-relay/issues) から

プルリクエストも大歓迎です！

---

## 📞 サポート

問題が発生した場合：

1. **Issues** で類似の問題がないか検索
2. 新しい Issue を作成し、以下を記載：
   - 使用している Minecraft バージョン
   - 使用している Quilt バージョン
   - エラーメッセージ
   - 実行した手順

---

**Made with ❤️ for Minecraft lovers**

🔗 [リポジトリ](https://github.com/warasugitewara/discord-chat-relay) | 📦 [リリース](https://github.com/warasugitewara/discord-chat-relay/releases)
