# Discord Chat Relay - ビルドセットアップガイド（Java 25対応）

## 概要
このプロジェクトはJava 25で動作するよう設定されています。
以下のいずれかの方法でビルドできます。

---

## 推奨方法: VSCode + Gradle for Java

**難易度**: ⭐⭐☆☆☆ （簡単）

### セットアップ（5分）

1. **VSCodeをインストール**
   - https://code.visualstudio.com/

2. **拡張機能をインストール**
   - VSCode → `Ctrl+Shift+X`
   - 検索: "Extension Pack for Java" → Install
   - 検索: "Gradle for Java" → Install

3. **プロジェクトを開く**
   ```powershell
   cd C:\Users\waras\Workspace\DiscordChatRelay
   code .
   ```

### ビルド実行

VSCodeで `Ctrl+Shift+B` を押すだけ！

または `Ctrl+Shift+P` → "Gradle: build"

**初回**: 5-10分（依存関係をダウンロード）
**2回目以降**: 1-2分

---

## 代替方法1: コマンドラインのみ

**難易度**: ⭐⭐⭐☆☆ （中程度）

### 前提条件
- Java 25: ✅ インストール済み
- Git: ✅ インストール済み

### セットアップ（初回のみ）

```powershell
# Gradleをダウンロード
$url = "https://services.gradle.org/distributions/gradle-8.4-bin.zip"
$dest = "$env:TEMP\gradle-8.4.zip"
Invoke-WebRequest -Uri $url -OutFile $dest -UseBasicParsing

# 解凍
Expand-Archive -Path $dest -DestinationPath "C:\" -Force

# PATH に追加（現在のセッションのみ）
$env:Path = "C:\gradle-8.4\bin;$env:Path"

# 確認
gradle -version
```

### ビルド実行

```powershell
cd C:\Users\waras\Workspace\DiscordChatRelay
gradle clean build
```

出力ファイル:
```
build/libs/discord-chat-relay-1.0.0.jar
```

---

## 代替方法2: Docker を使う

**難易度**: ⭐⭐⭐⭐☆ （高度）

Dockerがインストールされている場合：

```powershell
cd C:\Users\waras\Workspace\DiscordChatRelay

# Dockerコンテナでビルド
docker run --rm `
  -v ${PWD}:/workspace `
  -w /workspace `
  gradle:8.4-jdk25 `
  gradle build
```

---

## トラブルシューティング

### 問題: "Command 'gradle' is not recognized"

**解決方法:**
```powershell
# PATH に Gradle を追加（永続的）
[Environment]::SetEnvironmentVariable("Path", "C:\gradle-8.4\bin;$env:Path", [EnvironmentVariableTarget]::User)

# PowerShell を再起動後
gradle -version
```

### 問題: "Java version mismatch"

**解決方法:**
```powershell
# Java 25 を明示的に指定
$env:JAVA_HOME = "C:\Program Files\java\graalvm-jdk-25.0.1+8.1"
gradle build
```

### 問題: "Out of memory"

**解決方法:**
```powershell
$env:GRADLE_OPTS = "-Xmx4g"
gradle build
```

### 問題: ビルドが遅い

初回ビルドは10分以上かかる場合があります。これは正常です。
2回目以降は高速化します。

---

## ビルド後

### ファイルの確認

```powershell
ls build/libs/
```

出力:
```
discord-chat-relay-1.0.0.jar
```

### Minecraftにインストール

JARファイルをMinecraftのmodsフォルダにコピー：

```powershell
# Minecraftインストールパスを確認
$minecraftPath = "$env:APPDATA\.minecraft"

# modsフォルダが無ければ作成
mkdir "$minecraftPath\mods" -ErrorAction SilentlyContinue

# JARをコピー
Copy-Item -Path "build/libs/discord-chat-relay-1.0.0.jar" `
          -Destination "$minecraftPath\mods\"
```

### Minecraftで動作確認

1. Minecraftランチャーを開く
2. Version: `1.21.10` + Quilt Loader を選択
3. Play をクリック
4. Esc → Options → ModMenu → Discord Chat Relay で設定

---

## 開発中の頻繁なビルド

```powershell
# リアルタイムビルド（ファイル変更を監視）
gradle build --continuous
```

---

## よくある質問

**Q: VSCodeでJavaの構文チェックが働かない**
A: VSCodeを再起動してください。

**Q: ビルドが失敗する**
A: 以下を実行してください:
```powershell
gradle clean build
```

**Q: 特定のクラスのコンパイルエラー**
A: キャッシュをクリア:
```powershell
gradle clean
gradle build
```

---

## サポート

問題が発生した場合：
1. このドキュメントを再度確認
2. VSCode を再起動
3. ターミナルのエラーメッセージを確認
4. `gradle clean build` を実行

詳細は `DEVELOPMENT.md` を参照してください。
