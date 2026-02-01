# 🔴 ビルドエラー解決 - VSCode Java Extension を使う

## 問題
- CLI Gradle でのビルドが失敗（Maven 依存関係が見つからない）
- `Ctrl+Shift+B` でタスクが表示されない

---

## ✅ 解決策（推奨）

### ステップ 1: VSCode で拡張機能をインストール

```
1. VSCode を開く
2. Ctrl+Shift+X で拡張機能を開く
3. "Extension Pack for Java" を検索
4. マイクロソフトの公式版をインストール
5. VSCode を再起動
```

### ステップ 2: ビルド実行

```
方法A（推奨）: VSCode の terminal から実行
   Ctrl+Grave (` キー) で Terminal を開く
   以下を入力：
   .\gradlew build

方法B: VSCode の Run & Debug
   Ctrl+Shift+D で Run パネルを開く
   「Gradle Build」を選択して実行
```

### ステップ 3: 確認

```
✅ Build successful なメッセージが出たら OK
✅ build/libs/discord-chat-relay-1.0.0.jar が作成される
```

---

## 🚀 なぜ VSCode Java Extension が必要か？

| 機能 | CLI Gradle | VSCode Java |
|------|-----------|------------|
| Maven リポジトリ解決 | ❌ ローカルキャッシュのみ | ✅ 自動ダウンロード |
| IDE 統合 | ❌ なし | ✅ あり |
| エラー表示 | ❌ テキストのみ | ✅ ファイルの問題箇所を指摘 |
| デバッグ | ❌ できない | ✅ できる |

---

## 📝 build.gradle の注意

現在、以下の依存関係が有効になっています：

```gradle
modImplementation "org.quiltmc.quilted-fabric-api:quilted-fabric-api:14.3.1+1.21.3-1.21.10"
modImplementation "com.terraformersmc:modmenu:5.16.0"
modImplementation "me.shedaniel.cloth:cloth-config-1.21.10:14.2.119"
modImplementation "maven.modrinth:betterf3:9.0.3"
```

これらは **VSCode Java Extension が自動的に解決します**。

---

## 🔧 もし VSCode で失敗した場合

1. VSCode を完全に閉じる
2. `~/.gradle/caches` を削除
   ```powershell
   rm -r $env:USERPROFILE\.gradle\caches
   ```
3. VSCode を再度開く
4. Ctrl+Grave で Terminal を開く
5. `.\gradlew clean build` を実行

---

## 💡 Terminal コマンド一覧

```powershell
# 通常のビルド
.\gradlew build

# クリーン + ビルド
.\gradlew clean build

# 出力が見たい場合（詳細表示）
.\gradlew build --info

# デバッグモード
.\gradlew build --debug
```

---

## ✨ 成功した場合の出力例

```
> Task :compileJava
> Task :processResources
> Task :classes
> Task :jar
> Task :assemble
> Task :build

BUILD SUCCESSFUL in 3m 45s
```

👉 この場合、`build/libs/discord-chat-relay-1.0.0.jar` が生成されます！
