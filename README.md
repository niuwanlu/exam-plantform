# 虚拟考试系统的分层架构实现

### 运行

```bash
./gradlew run
```

浏览器中打开 http://localhost:8080/papers 即可



### 说明

目前有 paper, blank quiz 部分



### 现有操作

| 功能          | Method | URI               |
| ------------- | ------ | ----------------- |
| 获取所有paper | GET    | /papers           |
| 组卷          | POST   | /papers           |
| 重新组卷      | PUT    | /papers/:paper_id |
| 获取所有blank quiz | GET | /blankquizzes  |
| 获取某个blank quiz | GET | /blankquizzes/:blankquiz_id |
| 创建blank quiz    | POST | /blankquizzes  |
| 修改blank quiz    | PUT  | /blankquizzes/:blankquiz_id |
| 删除blank quiz    | DELETE | /blankquizzes/:blankquiz_id |