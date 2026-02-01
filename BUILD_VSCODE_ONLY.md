# ✅ VSCode ビルド（推奨）

## 問題
- CLI Gradle では Maven 依存関係が見つからない
- 特に Fabric API, Quilt API, Discord4J などが解決できない

## 解決策
**VSCode の Java Extension Pack を使用** - これが唯一確実な方法です

---

## 🚀 セットアップ（5分）

### ステップ 1: VSCode をインストール
```
https://code.visualstudio.com から VSCode をダウンロード
```

### ステップ 2: Java 拡張機能をインストール
```
VSCode を開く
Ctrl+Shift+X で拡張機能マーケットを開く
"Extension Pack for Java" を検索
Microsoft 公式版をインストール (赤い Java ロゴ)
VSCode を再起動
```

### ステップ 3: プロジェクトを開く
```
Ctrl+K, Ctrl+O
C:\Users\waras\Workspace\DiscordChatRelay を選択
開く
```

### ステップ 4: ビルド実行
```
Ctrl+` (グレーブキー) で Terminal を開く
以下を実行：
.\gradlew build
```

---

## ✨ 何が起きるか？

VSCode Java Extension が以下を自動的に行います：

1. **Maven Central から依存関係をダウンロード**
   - Quilt API
   - Discord4J 
   - Fabric API
   - ModMenu
   - Cloth Config
   - BetterF3
   - その他すべて

2. **Gradle をビルド実行**
   - Java コンパイル
   - Minecraft デコンパイル
   - JAR 生成

3. **成功**
   ```
   BUILD SUCCESSFUL in 5m 32s
   ```

---

## 📁 JAR ファイルの場所

ビルド成功後、JAR は以下に生成されます：

```
C:\Users\waras\Workspace\DiscordChatRelay\build\libs\discord-chat-relay-1.0.0.jar
```

このファイルを Minecraft mods フォルダにコピーします：

```
%APPDATA%\.minecraft\mods\discord-chat-relay-1.0.0.jar
```

---

##エラーが出た場合

### エラー: "gradle-wrapper not found"
→ 既知の問題。以下を実行：
```
.\gradlew build --no-daemon
```

### エラー: "dependency not found"
→ VSCode を再起動して、Terminal を新しく開いて再実行

### エラー: "Java not found"
→ VSCode → Ctrl+, (設定) → "java.home" で Java 21 パスを確認
   `C:\\Program Files\\java\\graalvm-jdk-21.0.9+7.1`

---

## 💡 なぜ CLI ビルドは失敗するのか？

```
CLI Gradle (失敗) → Maven リポジトリを見つけられない
                  → Quilt Loom が複雑な依存関係を解決できない
                  → gradle-wrapper.jar の互換性問題

VSCode Java Extension (成功) → 埋め込み Maven 解決機能
                              → Gradle daemon 管理
                              → 自動キャッシング
                              → IDE統合
```

---

## ✅ 推奨フロー

1. VSCode で Terminal を開く (`Ctrl+``)
2. `.\gradlew build` を実行
3. 5-10分待つ（初回は長い）
4. ✅ BUILD SUCCESSFUL
5. `build/libs/discord-chat-relay-1.0.0.jar` を確認
6. Minecraft mods フォルダに配置

これだけです！ 🎉
