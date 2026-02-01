# VSCodeでのビルド（最も簡単な方法）

## 5分で始める

### ステップ1: VSCodeをインストール
まだインストールしていなければ、以下からダウンロード：
https://code.visualstudio.com/download

### ステップ2: 拡張機能をインストール

VSCodeで以下を実行：
```
Ctrl+Shift+X  →  "Extension Pack for Java" を検索  →  Install
```

自動的に以下がインストールされます：
- Language Support for Java (Red Hat)
- Debugger for Java
- Test Runner for Java
- Visual Studio IntelliCode
- Maven for Java
- Visual Studio Code Debugger for Java

### ステップ3: 拡張機能をインストール（その2）

```
Ctrl+Shift+X  →  "Gradle for Java" を検索  →  Install
```

### ステップ4: プロジェクトを開く

```
File  →  Open Folder  →  C:\Users\waras\Workspace\DiscordChatRelay
```

または、PowerShellで：
```powershell
cd C:\Users\waras\Workspace\DiscordChatRelay
code .
```

### ステップ5: ビルド実行

VSCodeで以下を実行：
```
Ctrl+Shift+B
```

または：
```
Ctrl+Shift+P  →  "Gradle: build" と入力  →  Enter
```

### ステップ6: 待機

ビルドが実行されます（初回は5-10分かかる場合があります）。
ターミナルパネルで進行状況が表示されます。

### ステップ7: 完了確認

成功すると以下が表示されます：
```
BUILD SUCCESSFUL
```

そして、ファイルが生成されます：
```
build/libs/discord-chat-relay-1.0.0.jar
```

---

## トラブルシューティング

### エラー: "Java 21+ required"

以下をVSCodeの設定に追加：

```
Ctrl+Shift+P  →  "Preferences: Open Settings (JSON)"
```

以下を追加：
```json
"java.configuration.runtimes": [
  {
    "name": "JavaSE-25",
    "path": "C:\\Program Files\\java\\graalvm-jdk-25.0.1+8.1",
    "default": true
  }
]
```

その後、VSCodeを再起動。

### エラー: "Gradle plugin not found"

```
Ctrl+Shift+P  →  "Gradle: Refresh"
```

### ビルドが遅い

初回ビルドは依存関係をダウンロードするため10分程度かかります。
コーヒーを飲みながら待ってください ☕

### メモリ不足

VSCodeのターミナルで：
```powershell
$env:GRADLE_OPTS = "-Xmx2g"
```

---

## コマンドラインでのビルド（VSCode不要）

PowerShellで直接実行する場合：

### 準備（1回だけ）
```powershell
$env:JAVA_HOME = "C:\Program Files\java\graalvm-jdk-25.0.1+8.1"
$env:GRADLE_OPTS = "-Xmx2g"
```

### ビルド実行
```powershell
cd C:\Users\waras\Workspace\DiscordChatRelay
.\gradlew.bat build
```

---

## ビルド後

生成されたJARファイル：
```
C:\Users\waras\Workspace\DiscordChatRelay\build\libs\discord-chat-relay-1.0.0.jar
```

Minecraftのmodsフォルダにコピー：
```
%APPDATA%\.minecraft\mods\discord-chat-relay-1.0.0.jar
```

Minecraftを起動して、modが読み込まれることを確認してください！
