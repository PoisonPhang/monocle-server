- [Actions](#sec-1)
  - [getCurrentQuestion](#sec-1-1)
    - [Request](#sec-1-1-1)
    - [Response](#sec-1-1-2)
  - [startAttendance](#sec-1-2)
    - [Request](#sec-1-2-1)
    - [Response](#sec-1-2-2)
  - [createQuestion](#sec-1-3)
    - [Request](#sec-1-3-1)
    - [Response](#sec-1-3-2)
  - [checkin](#sec-1-4)


# Actions<a id="sec-1"></a>

## getCurrentQuestion<a id="sec-1-1"></a>

### Request<a id="sec-1-1-1"></a>

| Field | Type   | Description                                                |
|----- |------ |---------------------------------------------------------- |
| id    | string | The question id that the user currently has (0 by default) |

Example:

```json
{
  id: "eIdzIqo"
}
```

### Response<a id="sec-1-1-2"></a>

| Field      | Type   | Description                                 |
|---------- |------ |------------------------------------------- |
| type       | int    | 0 = Short Answer, 1 = Multiple Choice       |
| id         | string | Question id                                 |
| numChoices | string | Number of choices, 0 if not multiple choice |

Example:

```json
0
```

## startAttendance<a id="sec-1-2"></a>

### Request<a id="sec-1-2-1"></a>

None

### Response<a id="sec-1-2-2"></a>

| Field   | Type   | Description       |
|------- |------ |----------------- |
| status  | int    | 1 = Ok, 0 = Error |
| message | string | Optional message  |

Example:

```json
{
    "status": 0,
    "message": "ok"
}
```

## createQuestion<a id="sec-1-3"></a>

### Request<a id="sec-1-3-1"></a>

| Field      | Type          | Description                             |
|---------- |------------- |--------------------------------------- |
| question   | string        | Question to ask users                   |
| type       | int           | 0 = Short Answer, 1 = Multiple Choice   |
| numChoices | int           | Number of choices                       |
| choices    | array[string] | Answers for the multiple choicequestion |

Example:

```json
{
  "question": "What is 1+1?",
  "type": 1,
  "numChoices": 3,
  "choices": ["3", "42", "2", "All of the above."]
}
```

### Response<a id="sec-1-3-2"></a>

| Field   | Type   | Description       |
|------- |------ |----------------- |
| status  | int    | 0 = Ok, 1 = Error |
| message | string | Optional message  |

Example:

```json
{
    "status": 0,
    "message": "ok"
}
```

## checkin<a id="sec-1-4"></a>

| Field | Type   | Description                          |
|----- |------ |------------------------------------ |
| name  | string | Name of the user                     |
| code  | string | Attendance code given by the teacher |

Example:

```json
{
  "name": "Damien Appleheimer",
  "code": "dWeije18"
}
```
