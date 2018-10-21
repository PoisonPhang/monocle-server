- [Actions](#sec-1)
  - [getCurrentQuestion](#sec-1-1)
    - [Request](#sec-1-1-1)
    - [Response](#sec-1-1-2)
  - [getQuestionDetails](#sec-1-2)
    - [Request](#sec-1-2-1)
    - [Response](#sec-1-2-2)
  - [answerQuestion](#sec-1-3)
    - [Request](#sec-1-3-1)
    - [Response](#sec-1-3-2)
  - [lockQuestion](#sec-1-4)
    - [Request](#sec-1-4-1)
    - [Response](#sec-1-4-2)
  - [startAttendance](#sec-1-5)
    - [Request](#sec-1-5-1)
    - [Response](#sec-1-5-2)
  - [lockAttendance](#sec-1-6)
    - [Request](#sec-1-6-1)
    - [Response](#sec-1-6-2)
  - [createQuestion](#sec-1-7)
    - [Request](#sec-1-7-1)
    - [Response](#sec-1-7-2)
  - [checkin](#sec-1-8)
    - [Request](#sec-1-8-1)
    - [Response](#sec-1-8-2)
  - [checkinTeacher](#sec-1-9)
    - [Request](#sec-1-9-1)
    - [Response](#sec-1-9-2)
  - [getStudents](#sec-1-10)
    - [Request](#sec-1-10-1)
    - [Response](#sec-1-10-2)


# Actions<a id="sec-1"></a>

## getCurrentQuestion<a id="sec-1-1"></a>

### Request<a id="sec-1-1-1"></a>

| Field | Type   | Description                                                |
|----- |------ |---------------------------------------------------------- |
| id    | string | The question id that the user currently has (0 by default) |

Example:

```json
{
  "id": "eIdzIqo"
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
{
  "type": 1,
  "id": "eIDewoi",
  "numChoices": 5
}
```

## getQuestionDetails<a id="sec-1-2"></a>

### Request<a id="sec-1-2-1"></a>

None

### Response<a id="sec-1-2-2"></a>

| Field    | Type            | Description                            |
|-------- |--------------- |-------------------------------------- |
| question | QuestionRequest | Question details                       |
| answers  | array[Answer]   | Question answers                       |
| unlocked | boolean         | Whether the question  is locked or not |

QuestionRequest:

| Field      | Type          | Description                             |
|---------- |------------- |--------------------------------------- |
| question   | string        | Question to ask users                   |
| type       | int           | 0 = Short Answer, 1 = Multiple Choice   |
| numChoices | int           | Number of choices                       |
| choices    | array[string] | Answers for the multiple choicequestion |

Answer:

| Field  | Type   | Description              |
|------ |------ |------------------------ |
| name   | string | User name                |
| answer | string | User answer for question |

## answerQuestion<a id="sec-1-3"></a>

### Request<a id="sec-1-3-1"></a>

| Field  | Type   | Description                            |
|------ |------ |-------------------------------------- |
| id     | string | The question id that is being answered |
| name   | string | The name of the user                   |
| answer | string | The user's answer                      |

Example:

```json
{
  "id": "eIdzIqo",
  "name": "Damien Appleheimer",
  "answer": "1"
}
```

### Response<a id="sec-1-3-2"></a>

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

## lockQuestion<a id="sec-1-4"></a>

### Request<a id="sec-1-4-1"></a>

| Field | Type   | Description             |
|----- |------ |----------------------- |
| id    | string | The question id to lock |

Example:

```json
{
  "id": "eIdzIqo",
}
```

### Response<a id="sec-1-4-2"></a>

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

## startAttendance<a id="sec-1-5"></a>

### Request<a id="sec-1-5-1"></a>

None

### Response<a id="sec-1-5-2"></a>

| Field   | Type   | Description               |
|------- |------ |------------------------- |
| status  | int    | 1 = Ok, 0 = Error         |
| message | string | Optional message          |
| code    | string | Attendance code for users |

Example:

```json
{
    "status": 0,
    "message": "ok",
    "code": "wDwoaDp"
}
```

## lockAttendance<a id="sec-1-6"></a>

### Request<a id="sec-1-6-1"></a>

None

### Response<a id="sec-1-6-2"></a>

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

## createQuestion<a id="sec-1-7"></a>

### Request<a id="sec-1-7-1"></a>

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

### Response<a id="sec-1-7-2"></a>

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

## checkin<a id="sec-1-8"></a>

### Request<a id="sec-1-8-1"></a>

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

### Response<a id="sec-1-8-2"></a>

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

## checkinTeacher<a id="sec-1-9"></a>

| Field | Type   | Description                          |
|----- |------ |------------------------------------ |
| name  | string | Name of the user                     |
| code  | string | Attendance code given by the teacher |

### Request<a id="sec-1-9-1"></a>

| Field | Type   | Description         |
|----- |------ |------------------- |
| name  | string | Name of the teacher |

Example:

```json
{
  "name": "Mr. Cloudypants"
}
```

### Response<a id="sec-1-9-2"></a>

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

## getStudents<a id="sec-1-10"></a>

### Request<a id="sec-1-10-1"></a>

None

### Response<a id="sec-1-10-2"></a>

| Field    | Type          | Description                             |
|-------- |------------- |--------------------------------------- |
| status   | int           | 1 = Ok, 0 = Error                       |
| message  | string        | Optional message                        |
| users    | array[string] | List of users who have signed in        |
| unlocked | boolean       | Whether or not the attendance is locked |
