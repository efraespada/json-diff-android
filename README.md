# JSONDiff Android Calculator

Get JSON differences on Android platform
```groovy
implementation 'com.efraespada:jsondiff:1.1.2'
```

### Methods

#### hash(JSONObject object) : String
Returns a string hash for the given JSON object. It also accepts String objects.

#### diff(JSONObject a, JSONObject b) : Map<String, JSONObject>
Returns a map of changes:
```json
// a
{
    "chats": {
        "my_chat": {
            "name": "Group name",
            "counter": 23
        }
    }
}
```
```json
// b
{
    "chats": {
        "my_chat": {
            "name": "Group name 🤭"
        }
    }
}
```
```json
{
    "$set": {
        "chats.my_chat.name": "Group name 🤭"
    },
    "$unset": {
        "chats.my_chat.counter": 23
    }
}
```

