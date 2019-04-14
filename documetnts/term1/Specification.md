# 仕様書

## 画面一覧

### 記事一覧画面
- 上タブにカテゴリが存在し、スワイプ、もしくは上タブタップをする事によって記事一覧を切り替える事が出来る
  - ViewPagerを用いる
- サムネイルが表示される、また記事Topは目立つように工夫されている
  - RecyclerViewを用いる
- 記事明細をタップすると、WebViewで詳細ページが開く


#### 追加仕様（可能であれば実装する）
- [ ] 日付で降順でソートされている
- [ ] 過去に読み込んだ記事が端末の永続領域にキャッシュされ、次回起動時は差分のみ取得
- [ ] Swipe to Refreshで最新の記事を読み込む
- [ ] 明細に詳細詳細説明をレイアウトが崩れない範囲で表示する

### 記事詳細画面
- WebView(Chrome Custom tab)で渡されたURLを開く

## 対向システム
- RSS取得元は、下記のはてなのRSSとする。

```
総合 : http://b.hatena.ne.jp/hotentry.rss
世の中 : http://b.hatena.ne.jp/hotentry/social.rss
政治と経済 : http://b.hatena.ne.jp/hotentry/economics.rss
暮らし : http://b.hatena.ne.jp/hotentry/life.rss
```