# Discord Chat Relay - VSCode ビルド完全ガイド

## 📋 概要

このプロジェクトはVSCodeで**最も簡単に**ビルドできるように完全に設定されています。

## 🚀 クイックスタート（3ステップ）

### ステップ1: VSCodeのセットアップ

**VSCodeをインストール:**
```powershell
# Chocolateyを使用
choco install vscode

# または scoop
scoop install vscode

# または直接ダウンロード
# https://code.visualstudio.com/Download
```

**Javaサポートを追加:**
1. VSCodeを起動
2. `Ctrl+Shift+X` で拡張機能を開く
3. `Extension Pack for Java` を検索
4. **Microsoftの拡張機能** をクリック → **Install**

⏱️ インストール時間: **3分**

---

### ステップ2: プロジェクトを開く

**方法A: スクリプトで開く（推奨）**
```powershell
cd C:\Users\waras\Workspace\DiscordChatRelay
.\open-vscode.bat
```

**方法B: 手動で開く**
1. VSCodeメニュー: `File` → `Open Folder`
2. `C:\Users\waras\Workspace\DiscordChatRelay` を選択
3. フォルダを開く

**VSCodeが自動的に:**
- ✅ Javaをセットアップ
- ✅ Gradleプロジェクトを認識
- ✅ 必要なライブラリをダウンロード

⏱️ セットアップ時間: **2-3分** ☕

**ステータスを確認:**
```
VSCode 下部バー → Java Language Server
🔵 Loading...  → ✅ Ready
```

---

### ステップ3: ビルド実行

**最速の方法:**
```
Ctrl + Shift + B
```

表示されたメニューで **gradle build** を選択 → Enter

**ビルド進行状況:**
```
> Configuring project...
> Downloading dependencies...
> Compiling Java files...
> Creating JAR...

BUILD SUCCESSFUL ✅
```

⏱️ ビルド時間: **5-10分（初回）**, **1-2分（以降）**

---

## 📁 完成ファイル

ビルド成功時：

```
build/
└── libs/
    └── discord-chat-relay-1.0.0.jar  ✅ 完成！
```

### ファイルの確認

**VSCode内:**
1. 左サイドバー **エクスプローラー** をクリック
2. `build` → `libs` を展開
3. `discord-chat-relay-1.0.0.jar` が表示される

**またはPowerShellで:**
```powershell
ls build/libs/
# discord-chat-relay-1.0.0.jar が表示されます
```

---

## 🎮 Minecraftにインストール

### JARファイルをコピー

```powershell
$minecraftPath = "$env:APPDATA\.minecraft"

# Modsフォルダがなければ作成
mkdir "$minecraftPath\mods" -ErrorAction SilentlyContinue

# JARをコピー
Copy-Item "build/libs/discord-chat-relay-1.0.0.jar" `
          "$minecraftPath\mods\"

# 確認
ls "$minecraftPath\mods\*discord*"
```

### Minecraftで設定

1. Minecraftランチャーを開く
2. バージョン: `1.21.10`
3. Loader: **Quilt**
4. **Play** をクリック
5. Esc → Options → **ModMenu** → **Discord Chat Relay**

6. 設定:
   - **Bot Token**: Discordから取得
   - **Channel ID**: 送信先チャンネルID
   - **Enabled**: ON ✅

7. チャットを送ると → **Discordに表示される** 🎉

---

## 🛠️ VSCodeの便利機能

### ビルド関連

| キー | 機能 |
|------|------|
| `Ctrl+Shift+B` | ビルド実行 |
| `Ctrl+Shift+B` 2回 | Gradle: clean → build |
| `Ctrl+Shift+P` | コマンドパレット（任意コマンド実行） |

### コード編集

| キー | 機能 |
|------|------|
| `Ctrl+F` | ファイル内検索 |
| `Ctrl+Shift+F` | プロジェクト全体検索 |
| `F2` | 変数名をリファクタリング |
| `Ctrl+/` | コメント切り替え |
| `Ctrl+Shift+P` → Format | 自動フォーマット |

### ナビゲーション

| キー | 機能 |
|------|------|
| `Ctrl+Click` | クラス定義へジャンプ |
| `Ctrl+Alt+← →` | 前後へ移動 |
| `Ctrl+G` | 行番号ジャンプ |

---

## ⚠️ トラブルシューティング

### 問題: ビルドが遅い/ハング

**原因**: 初回は依存関係をダウンロード中

**対策**:
- ☕ コーヒーを飲んで待つ
- インターネット接続を確認
- 2回目以降は高速になります

### 問題: "Gradle plugin not found"

```
Ctrl+Shift+P → "Gradle: Refresh"
```

### 問題: ビルド失敗（エラーメッセージ）

**VSCodeの下部パネル（ターミナル）でエラーを確認:**

```
Ctrl+Shift+P → "Tasks: Run Task" → "Gradle: clean"
```

その後再度ビルド

### 問題: Java 21が見つからない

VSCode設定を編集:
```
Ctrl+Shift+P → "Preferences: Open Settings (JSON)"
```

以下を追加：
```json
{
  "java.configuration.runtimes": [
    {
      "name": "JavaSE-21",
      "path": "C:\\Program Files\\java\\graalvm-jdk-21.0.9+7.1",
      "default": true
    }
  ]
}
```

保存して VSCode を再起動

---

## 📚 ドキュメント

- [VSCODE_QUICK.md](VSCODE_QUICK.md) - 3ステップガイド
- [VSCODE_DETAILED.md](VSCODE_DETAILED.md) - 詳細ガイド
- [README.md](README.md) - ユーザーガイド
- [BUILD_SETUP.md](BUILD_SETUP.md) - ビルドオプション

---

## 🎯 次のステップ

1. ✅ VSCode + Java Extension Packをインストール
2. ✅ プロジェクトを開く
3. ✅ `Ctrl+Shift+B` でビルド
4. ✅ `discord-chat-relay-1.0.0.jar` を確認
5. ✅ MinecraftのModsフォルダにコピー
6. ✅ Minecraftで設定
7. ✅ チャット送信 → Discord表示される！

---

**これだけで完成です！ Happy Building! 🚀**
