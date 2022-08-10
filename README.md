# react-native-inapp-review-rating
In app rating
## Installation

```sh
npm install react-native-inapp-review-rating
```

## Usage

```js
inAppReviewFlowRequest().then(()=>{
                    inAppReviewShow().then(()=>{
                        saveItem(showInAppReviewOnceKey, true);
                        shopCashAnalytics.logEventForFireBase('show_inappreviewrating', {
                        on_show_inappreviewrating: true,

                    })
        });
// ...

const result = await multiply(3, 7);
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
