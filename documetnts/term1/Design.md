# 設計

## UseCase一覧
- 記事カテゴリに紐づく、記事の一覧を取得する。
   - input : 記事カテゴリ 
   - output : 記事モデルのリスト

- 記事カテゴリの一覧を取得する
   - input : なし
   - output : 記事カテゴリの一覧

## DomainModel一覧

### 記事カテゴリ
- カテゴリ名
- カテゴリコード

### 記事
- 記事タイトル
- サムネイルURL
- 記事詳細URL

## リスク
- カテゴリがリモートの値を参照・自分で追加等で可変になる
   - 固定ではなく可変の場合でも簡単に対応可能にしておく
