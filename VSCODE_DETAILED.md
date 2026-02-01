# VSCodeでのビルド手順（完全ガイド）

## ステップ1: VSCodeをインストール

### Windows
1. https://code.visualstudio.com/download にアクセス
2. **Windows** をクリック
3. ダウンロードしたexeを実行
4. インストール完了

## ステップ2: Java拡張機能をインストール

### 方法A: 推奨（自動一括インストール）

1. VSCodeを起動
2. `Ctrl+Shift+X` を押して **拡張機能** パネルを開く
3. 検索ボックスに `Extension Pack for Java` と入力
4. **Microsoft** が提供している **Extension Pack for Java** の **Install** をクリック

![拡張機能](https://code.visualstudio.com/assets/docs/java/extensions.png)

自動的に以下がインストールされます：
- ✅ Language Support for Java (Red Hat)
- ✅ Debugger for Java
- ✅ Test Runner for Java
- ✅ Visual Studio IntelliCode
- ✅ Maven for Java
- ✅ Project Manager for Java
- ✅ Visual Studio Code Debugger for Java

### 方法B: 手動（不要）

各拡張機能を個別にインストール（推奨しません）

## ステップ3: プロジェクトをVSCodeで開く

### 方法A: VSCodeメニューから

1. VSCodeを起動
2. `File` → `Open Folder`
3. `C:\Users\waras\Workspace\DiscordChatRelay` を選択
4. **フォルダを開く** をクリック

### 方法B: PowerShellから（簡単）

```powershell
cd C:\Users\waras\Workspace\DiscordChatRelay
code .
```

実行してEnter → VSCodeが自動的にこのフォルダで起動します

## ステップ4: 自動セットアップを待つ

フォルダを開くと、VSCodeが自動的に以下を実行します：

1. Java言語サーバーを起動
2. プロジェクトを解析
3. Gradleプロジェクトを認識
4. 必要なJDKを確認

**初回は2-3分かかります** ☕

画面下部に進捗が表示されます：
```
[Gradle for Java] Loading Gradle Projects...
```

完了すると消えます。

## ステップ5: Gradleタスクを実行

### 方法A: キーボードショートカット（最速）

1. `Ctrl+Shift+B` を押す
2. ドロップダウンが表示されます

![タスク選択](画面例)

3. **gradle build** を選択
4. ビルド開始！

### 方法B: コマンドパレットから

1. `Ctrl+Shift+P` を押す
2. `Tasks: Run Task` と入力して Enter
3. **Gradle: build** を選択
4. ビルド開始！

### 方法C: サイドバーから

1. 左サイドバーの **Gradle** アイコンをクリック
2. プロジェクトツリーが表示される
3. `discord-chat-relay` → `Tasks` → `build` をダブルクリック

## ステップ6: ビルド進行状況を監視

VSCodeの下部パネル（ターミナル）でビルド状況が表示されます：

```
> Configure project :
Quilt Loom: 1.7.4

> Task :compileJava
...

BUILD SUCCESSFUL
```

### 初回ビルド
- **5～10分かかります**
- Maven リポジトリからダウンロード中
- コンパイル中

### 2回目以降
- **1～2分**（キャッシュを使用）

## ステップ7: ビルド完了の確認

成功時：
```
BUILD SUCCESSFUL in XXs
```

出力ファイル:
```
build/libs/discord-chat-relay-1.0.0.jar
```

**エクスプローラー** で確認：
1. VSCodeの左サイドバー **エクスプローラー** をクリック
2. `build` → `libs` を展開
3. `discord-chat-relay-1.0.0.jar` が表示される ✅

## トラブルシューティング

### エラー: "Java 21+ required"

```
Gradle property 'org.gradle.java.home' is set to an invalid directory
```

**解決方法:**

1. `Ctrl+Shift+P` → **Preferences: Open Settings (JSON)**
2. 以下を追加：

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

3. VSCodeを再起動

### エラー: "Gradle plugin not found"

```
Ctrl+Shift+P → "Gradle: Refresh"
```

で手動リフレッシュ

### エラー: "Out of memory"

```
Ctrl+Shift+P → "Preferences: Open Settings (JSON)"
```

以下を追加：

```json
{
  "gradle.jvmArgs": ["-Xmx2g"]
}
```

### ビルドが遅い・ハング

1. ターミナルパネルを確認（ダウンロード中？）
2. コーヒーを飲んで待つ ☕
3. 30分以上ハング → VSCode再起動

## 次のステップ

### ビルド完了後

```
✅ build/libs/discord-chat-relay-1.0.0.jar が生成されました
```

このJARを Minecraft の `mods` フォルダにコピー：

```powershell
$minecraftPath = "$env:APPDATA\.minecraft"
Copy-Item "build/libs/discord-chat-relay-1.0.0.jar" "$minecraftPath/mods/"
```

### ビルド後の開発

コード変更 → `Ctrl+Shift+B` でリビルド

**VSCodeの便利機能:**
- `Ctrl+Click` - クラス定義へジャンプ
- `Ctrl+F` - ファイル内検索
- `Ctrl+Shift+F` - プロジェクト全体検索
- `F2` - 変数名をリファクタリング

## よくある質問

**Q: ビルドが失敗した場合**

A: 以下を実行：
```powershell
cd C:\Users\waras\Workspace\DiscordChatRelay
code . 
# VSCodeで Ctrl+Shift+B → Gradle: clean を実行
# その後 Ctrl+Shift+B → Gradle: build を実行
```

**Q: JAR後どうする？**

A: `%APPDATA%\.minecraft\mods` にコピーしてMinecraft起動

**Q: Eclipse/IntelliJの方が良い？**

A: VSCodeが最も軽量で、この用途に十分です

**Q: コマンドラインビルドはできない？**

A: VSCodeのGradleが環境を完全に管理するため、CLIは不要です

---

**次: VSCodeをインストール → Extension Pack for Javaをインストール → コマンドで実行！**
