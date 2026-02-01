# VSCode Quick Start（3ステップで開始）

## ステップ1️⃣: VSCodeをインストール

**Windows で実行:**

```powershell
# PowerShellを管理者として開く
# scoop でインストール（推奨）
scoop install vscode

# または直接ダウンロード
# https://code.visualstudio.com/Download → Windows → ダウンロード & 実行
```

## ステップ2️⃣: このスクリプトを実行

```powershell
cd C:\Users\waras\Workspace\DiscordChatRelay
.\open-vscode.bat
```

**このコマンド1つで:**
- ✅ VSCodeが起動
- ✅ プロジェクトが開かれる
- ✅ Java言語サーバーが起動
- ✅ Gradleが認識される

**待機画面**

```
[Java Language Server] Initializing...
[Gradle for Java] Loading Gradle Projects...

⏳ 1-3分待機（初回のみ）
```

## ステップ3️⃣: ビルド実行

VSCodeで以下を実行：

### 最速（推奨）
```
Ctrl + Shift + B
```

ドロップダウンが表示 → **gradle build** を選択 → Enter

### または
```
Ctrl + Shift + P
```

`Tasks: Run Task` と入力 → `Gradle: build` を選択

---

## ビルド進行状況

### ターミナルパネルに表示

```
> Configure project :
Quilt Loom: 1.7.4

> :compileJava
Compiling 6 Java files...

> :jar
...

BUILD SUCCESSFUL in 5m 23s
```

### 完了の確認

```
✅ build/libs/discord-chat-relay-1.0.0.jar
```

---

## トラブル時の対応

### Java 21が見つからない

VSCode内で：
```
Ctrl+Shift+P → "Java: Configure Runtime for Extension Pack for Java"
```

Java 21のパスを指定：
```
C:\Program Files\java\graalvm-jdk-21.0.9+7.1
```

### Gradle タスクが表示されない

```
Ctrl+Shift+P → "Gradle: Refresh Gradle Projects"
```

### ビルド失敗

VSCode のターミナルを確認 → エラーメッセージ を読む

```
Ctrl+Shift+B → "Gradle: clean"   (クリア)
Ctrl+Shift+B → "Gradle: build"   (再ビルド)
```

---

## 完成！

```
build/libs/discord-chat-relay-1.0.0.jar
           ↓
%APPDATA%\.minecraft\mods\ にコピー
           ↓
Minecraft 起動
```

---

## 便利なVSCode操作

| キー | 機能 |
|------|------|
| `Ctrl+Shift+B` | ビルド実行 |
| `Ctrl+Shift+P` | コマンドパレット |
| `Ctrl+Shift+X` | 拡張機能 |
| `Ctrl+F` | ファイル内検索 |
| `F5` | デバッグ開始 |
| `Ctrl+``  | ターミナル表示/非表示 |

---

**これだけ！VSCodeで開発開始できます** 🎉
