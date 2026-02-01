# クイックスタート - コマンドラインビルドガイド

Gradleのラッパー設定に問題がある場合は、このガイドを参照してください。

## 方法1: VSCodeの拡張機能を使う（最も簡単）

### 推奨される拡張機能
1. **Extension Pack for Java** (Microsoft)
   - Java language support
   - Visual Studio IntelliCode
   - Maven for Java
   - Project Manager for Java
   - Visual Studio Code Debugger for Java

2. **Gradle for Java** (Microsoft)
   - Gradle project explorer
   - Build task runner

### インストール手順
```
VSCode → Extensions → "Extension Pack for Java" を検索 → Install
VSCode → Extensions → "Gradle for Java" を検索 → Install
```

### ビルド実行
1. VSCodeで `Ctrl+Shift+P`
2. "Gradle: build" と入力 → Enter
3. ビルド完了まで待機

---

## 方法2: Gradle CLIを直接使う（Java 25対応）

### ステップ1: Gradleをセットアップ

```powershell
# PowerShellで実行
$gradleUrl = "https://services.gradle.org/distributions/gradle-8.4-bin.zip"
$tempZip = "$env:TEMP\gradle-8.4.zip"
$gradleDir = "C:\gradle"

# ダウンロード
Invoke-WebRequest -Uri $gradleUrl -OutFile $tempZip

# 解凍
Expand-Archive -Path $tempZip -DestinationPath $gradleDir

# 環境変数を設定（一時的）
$env:GRADLE_HOME = "$gradleDir\gradle-8.4"
$env:Path = "$env:GRADLE_HOME\bin;$env:Path"

# 確認
gradle -version
```

### ステップ2: プロジェクトでビルド

```powershell
cd C:\Users\waras\Workspace\DiscordChatRelay

# クリーンビルド
gradle clean build

# または
gradle build
```

---

## 方法3: Docker を使う（最も確実）

Dockerがインストールされている場合：

```dockerfile
FROM gradle:8.4-jdk25

WORKDIR /workspace

COPY . .

RUN gradle build
```

ビルド:
```bash
docker build -t discord-chat-relay .
docker run --rm -v %cd%\build:/workspace/build discord-chat-relay
```

---

## 出力確認

ビルド成功時、以下が生成されます：

```
build/libs/discord-chat-relay-1.0.0.jar
```

このJARを Modsフォルダにコピーしてください。

---

## トラブルシューティング

### Gradle Command Not Found
```powershell
# 永続的に PATH に追加
[Environment]::SetEnvironmentVariable("GRADLE_HOME", "C:\gradle\gradle-8.4", [EnvironmentVariableTarget]::User)
[Environment]::SetEnvironmentVariable("Path", "$env:Path;C:\gradle\gradle-8.4\bin", [EnvironmentVariableTarget]::User)

# PowerShell再起動後
gradle -version
```

### Java バージョンエラー
```powershell
# Java 25 を使用するように指定
$env:JAVA_HOME = "C:\Program Files\java\graalvm-jdk-25.0.1+8.1"
gradle build
```

### メモリ不足エラー
```powershell
$env:GRADLE_OPTS = "-Xmx2g"
gradle build
```
