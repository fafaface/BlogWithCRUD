java课设需求

提交的内容包括：

1. 数据库设计文档

2. 数据库文件

3. 完整的Java Web工程。

![image-20201204201211804](/home/aliceshair/.config/Typora/typora-user-images/image-20201204201211804.png)

前端：

1. 欢迎页面（首页）：实现照片的轮播，以及其他功能的链接等。index
2. 个人简介：个人情况的简单介绍界面，根据个人兴趣设计。selfintro

3. 个人核心竞争力：科研情况，学习成绩，开发技能，获奖 其他（可根据自己的喜好分类）。最好把这些做成下拉菜单的进行选择。skill
4. 家乡简介：家乡情况的简单介绍，根据个人兴趣设计。
5. 特色介绍：主要从美食、美景、风土人情等几方面进行介绍，但不局限于此，根据自己的喜好进行设计。  
6. 用户留言：设置留言板，游客可以留言，并能实现回复功能。

后端：

1. 用户管理：包括管理员和游客（游客可以注册，注册之后可以进行留言），管理员管理整个后端的信息
2. 技能管理：这部分包括了下拉菜单中涉及的科研情况管理，学习成绩等管理，开发技能管理等。管理指web界面实现（增删改查等工作）
3. 家乡特色介绍：这部分主要在web界面进行对美食、美景、风土人情的管理，实现增删改查等功能。
4. 留言管理：可以实现留言的管理。管理同上。

## Design

### 表

用户、科研情况、学习科目成绩、开发技能、获奖、家乡特色介绍、留言
user、experience、course、skill、award、feature/spot、comment

#### user
id type username password
//之所以加了 s 因为 user 可能是 psql 的关键字
```sql
CREATE TABLE "user"( 
   id INT PRIMARY KEY,
   type VARCHAR(255) NULL DEFAULT NULL,
   username VARCHAR(255) NULL DEFAULT NULL,
   password VARCHAR(255) NULL DEFAULT NULL
);
```
#### experience
id title start_date end_date institution role description
```sql
CREATE TABLE experience(
   id INT PRIMARY KEY,
   title VARCHAR(255) NULL DEFAULT NULL,
   start_date DATE NULL DEFAULT NULL,
   end_date DATE NULL DEFAULT NULL,
   institution VARCHAR(255) NULL DEFAULT NULL,
   role VARCHAR(255) NULL DEFAULT NULL,
   description VARCHAR(255) NULL DEFAULT NULL
);
```
#### course
id name grade
```sql
CREATE TABLE course(
   id INT PRIMARY KEY,
   name VARCHAR(255) NULL DEFAULT NULL,
   grade  NUMERIC(5,2) NULL DEFAULT NULL
);
```
#### award
id title award_date
```sql
CREATE TABLE award(
   id INT PRIMARY KEY,
   title VARCHAR(255) NULL DEFAULT NULL,
   award_date DATE NULL DEFAULT NULL
);
```
#### spot
id type title description image
```sql
CREATE TABLE spot(
   id INT PRIMARY KEY,
   type VARCHAR(255) NULL DEFAULT NULL,
    title VARCHAR(255) NULL DEFAULT NULL,
    description VARCHAR(255) NULL DEFAULT NULL
);
```
#### comment
id user_id content comment_time


### Endpoints

```
/api/login
/api/signup
/api/experiences
/api/courses
/api/awards
/api/spots
/api/comments
```


```
GET /api/spots 获取所有 spots
POST /api/spots 创建一个
PUT /api/spots/:id 更新指定的一个
DELETE /api/spots/:id 删除指定的一个
```

个人核心竞争力：

特色介绍：一个表，每行是一个条目，id、介绍的类型（美食、美景、bla）、名称、文字、图片
    WHERE type = '美食'

开始时间、结束时间、地点、详情、角色
课程名称、课程成绩
技能名称、技能等级
获奖项目、获奖级别、项目级别、获奖日期

