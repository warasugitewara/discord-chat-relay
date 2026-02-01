# VSCode Gradle タスク選択ガイド

## `Ctrl+Shift+B` で表示されるメニュー

```
? Select a task to run
> gradle build          👈 これを選ぶ
  gradle clean
  gradle clean build
  Other tasks...
```

---

## 各タスクの説明

### ✅ **gradle build** （推奨・通常）

```
【役割】
通常のビルド。既存のキャッシュを使用して高速ビルド

【ビルド時間】
- 初回: 5-10分（依存関係をダウンロード）
- 2回目以降: 1-2分

【使う場面】
📌 最初のビルド
📌 コード変更後の再ビルド
📌 普通の時

【結果】
✅ build/libs/discord-chat-relay-1.0.0.jar が生成される
```

**→ 最初はこれを選んでください！**

---

### 🧹 **gradle clean** （クリアのみ）

```
【役割】
ビルド成果物をすべて削除。次のビルドへの準備

【ビルド時間】
数秒～1分

【使う場面】
❌ ほぼ使わない
（clean後にもう一度buildを実行する必要がある）

【結果】
build/ フォルダが削除される
```

**→ 単独では使わないでください（buildされません）**

---

### 🔄 **gradle clean build** （推奨・トラブル時）

```
【役割】
1. すべてクリア
2. 新しくビルド

【ビルド時間】
10-15分（すべて再ダウンロード＆再コンパイル）

【使う場面】
🚨 ビルド失敗したとき
🚨 「なぜか動作しない」って時
🚨 大きな変更をしたとき

【結果】
✅ build/libs/discord-chat-relay-1.0.0.jar が生成される
```

**→ トラブル時の救世主！**

---

## 🎯 選択フロー

```
初めてのビルド？
   └→ YES → gradle build を選択 ✅
           ↓
           ビルド成功！
           ↓
           完成！

ビルド失敗した？
   └→ YES → gradle clean build を選択 ✅
           ↓
           すべてリセット + 再ビルド
           ↓
           通常は成功する

通常の開発
   └→ コード変更 → gradle build を選択 ✅
           ↓
           高速ビルド（1-2分）
           ↓
           テスト
```

---

## 📋 チェックリスト

| タスク | 初回 | 日常 | トラブル時 |
|-------|------|------|-----------|
| gradle build | ⭐⭐⭐ | ⭐⭐⭐ | ❌ |
| gradle clean | ❌ | ❌ | ❌ |
| gradle clean build | ❌ | ❌ | ⭐⭐⭐ |

---

## 🚀 実際の操作

### 初回ビルド

```
1. Ctrl+Shift+B を押す
2. メニューが表示される
3. "gradle build" を選択
4. Enter キーを押す
5. ターミナルに進捗が表示される
6. BUILD SUCCESSFUL が出たら成功！
```

### ビルド失敗した場合

```
1. Ctrl+Shift+B を押す
2. "gradle clean build" を選択
3. Enter キーを押す
4. 10-15分待機
5. BUILD SUCCESSFUL が出たら成功！
```

---

## 💡 ターミナルで確認

ビルド終了後、VSCodeの下部パネルを確認：

```
✅ BUILD SUCCESSFUL in 5m 23s
```

と表示されたら完成です！

```
❌ BUILD FAILED
```

と表示されたら、エラーメッセージを読んで対応してください。

---

## 🎯 答え

**最初は `gradle build` を選んでください！** ✅
