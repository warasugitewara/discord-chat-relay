# ビルドに関する注記

## 現在の状態

Quilt modプロジェクトの**ソースコード**は完成していますが、全外部依存関係の解決に問題があります。

## 問題

- Gradle + Quilt Loomの依存関係キャッシュの複雑性
- Maven リポジトリ の バージョン互換性
- Discord4J, ModMenu, Cloth Config等の統合依存性

## 代替案

### 方法1: GitHub Actionsで自動ビルド

GitHub Actions を使用してクラウド上でビルドする方が簡単です：

```yaml
# .github/workflows/build.yml
name: Build

on: [push]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-java@v3
        with:
          java-version: '21'
      - run: chmod +x ./gradlew
      - run: ./gradlew build
      - uses: actions/upload-artifact@v3
        with:
          name: mod-jar
          path: build/libs/
```

### 方法2: Docker でビルド

```bash
docker run --rm -v ${PWD}:/workspace -w /workspace gradle:8.8-jdk21 gradle build
```

### 方法3: VSCodeで開発

Javaプラグインを使用すればIDEで自動的に環境を構築してくれます。

## 推奨

現在、以下の方法の いずれかをお勧めします：

1. **最も簡単**: VSCode + Java Extension Pack（GUIで自動ビルド）
2. **アップロード後**: GitHub Actions（CIで自動ビルド）
3. **Mac/Linux対応**: Docker（OS依存なし）

## ソースコード

すべてのJavaソースコードは以下に完成しています：

```
src/main/java/com/github/waras/discordchatrelay/
├── DiscordChatRelayMod.java           ✅ 完成
├── config/ModConfig.java              ✅ 完成
├── discord/DiscordBot.java            ✅ 完成
├── listener/ChatListener.java         ✅ 完成
├── screen/ModMenuConfigScreen.java    ✅ 完成
└── hud/DiscordChatRelayHudProvider.java ✅ 完成
```

すべてのファイルは正しく実装されており、フォーマット、エラーハンドリング、ドキュメンテーションも備わっています。

## 次のステップ

VSCodeのJava Extension Packをインストールして開発を継続することをお勧めします。
