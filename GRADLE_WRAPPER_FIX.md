# 🔴 Gradle Wrapper 問題解決

## 問題
```
エラー: メイン・クラスorg.gradle.wrapper.GradleWrapperMainを初期化できません
原因: java.lang.NoClassDefFoundError: org/gradle/wrapper/IDownload
```

## 原因
`./gradlew` (Gradle Wrapper) が壊れている

## ✅ 解決策

### 方法 1: バッチファイルを使う（簡単）

```bash
# プロジェクトフォルダで以下を実行
.\build-simple.bat
```

### 方法 2: VSCode Terminal で直接実行

```bash
# Terminal を開く (Ctrl+`)
C:\gradle\gradle-8.8\bin\gradle.bat build
```

### 方法 3: Ctrl+Shift+B でタスクを実行

```
1. Ctrl+Shift+B
2. "gradle build" を選択
3. Enter
```

---

## 🎯 推奨フロー

```powershell
# Terminal を開く
Ctrl+`

# 直接実行
C:\gradle\gradle-8.8\bin\gradle.bat build
```

これだけです！ ✅

---

## なぜこれが必要か？

Gradle Wrapper (`./gradlew`) は以下の問題があります：

- JAR ファイルが破損している
- Java 互換性がない
- ダウンロード機能が失敗している

**解決策：** 直接 Gradle 8.8 を使用
