# AREASTATE
#### 技术栈简介

- 前端使用

  > AngularJs+ui-router搭建基础单页面应用

  > BootStrap实现页面响应式布局

  > require.js+angularAMD进行按序加载

- 后端使用

  > Maven进行项目的依赖管理

  > SSM搭建基本的后端框架

  > MySql作为数据库


#### 项目背景与简介

> **名称：**学校活动场地管理系统

> **背景简介：**目前本高校的活动场地多种多样，但管理方式还比较落后，如果某一个活动的主办方需要使用某个场地，需要事先给场地的监管人员电话，进行预约，但是，单单仅凭管理员的记忆能力，无法避免重复预约的情况，或者预约冲突的情况，故本人受到学校相关人员的委托，为学校制定一个管理系统，用于管理学校的活动场地。（本系统结合申请流程系统进行使用）

> **项目简介：**
>
> 一、角色
>
> (1)	管理员
> (2)	普通用户
>
> 二、需求概述
>
> ​	用户在提出场地申请前需要对学校场地事先进行一个锁定（通知管理员，XXX需要预约活动场地），锁定以后才能够到流程系统提交场地使用申请。现在需要对学校四个场地的状态进行统一管理，在系统中标识出每个场地的不同时间段的使用情况，分为（可用、已分配、过期、锁定）。系统标识出从当前日期开始的后半个月内（可配置）的场地锁定情况（状态情况）。用户在提交场地申请前需到本系统查看场地的可用情况，并根据自己的场地锁定提出场地使用申请（申请不需我们做，另外已经存在的系统）。
>
> 三、功能分析
> ![1](https://github.com/LQ55/AREASTATE/blob/master/src/main/webapp/images/1.png)
> > 功能结构图如下
>
> ![1](https://github.com/LQ55/AREASTATE/blob/master/src/main/webapp/images/1.png)
>
> > 分析
>
> 注：场地锁定与申请是两个独立的系统，申请系统目前已经有公司承包并开发。
>
> 1. 用户功能
>    - 用户在提出场地使用申请前需要对学校场地进行一个锁定。
>    - 用户在场地锁定管理系统选定一个场地的时间段进行锁定，锁定以后场地状态为锁定，产生一个锁定编号，该编号用于申请系统申请表单的某一个字段。
>    - 如果用户锁定了场地的某时段以后的一定时间内（可以设置）没有提出对该场地的使用申请，系统自动解锁该锁定，并将该时段状态恢复到可用状态。
>    - 系统默认展示出场地半个月内的场地锁定情况。
>    - 场地的每一天有三个时段可用：上午、下午、晚上。（用户锁定时，可以选定任意一个场地的任意一个时段）。
>    - 用户锁定以后可以取消锁定。
> 2. 管理员功能
>    - 管理员除了具有用户操作权限以外，还包含对场地的分配与解除。
>    - 分配：管理员同意用户在场地申请系统中提出的场地申请以后，在本系统进行分配操作，将场地分配给用户（只是一个状态的改变），此时该场地的该时段为已分配状态。
>    - 解除：管理员由于某些原因拒绝了用户提出的场地申请，此时需要管理员到本系统手动修改该场地的时段为场地状态（可用状态）。
>    - 管理员自己可以进行场地的锁定。
>
> 场地状态表：
>
> | 场地状态     | 说明                                           |
> | ------------ | ---------------------------------------------- |
> | 锁定         | 用户对场地某个时段进行了锁定，并且时间没有超限 |
> | 已分配       | 管理员同意了场地申请                           |
> | 过期（考虑） | 在当前日期之前的数据，场地状态显示为过期       |

#### 系统运行截图

![2](https://github.com/LQ55/AREASTATE/blob/master/src/main/webapp/images/2.png)

![3](https://github.com/LQ55/AREASTATE/blob/master/src/main/webapp/images/3.png)

![4](https://github.com/LQ55/AREASTATE/blob/master/src/main/webapp/images/4.png)

![5](https://github.com/LQ55/AREASTATE/blob/master/src/main/webapp/images/5.png)

![6](https://github.com/LQ55/AREASTATE/blob/master/src/main/webapp/images/6.png)

![7](https://github.com/LQ55/AREASTATE/blob/master/src/main/webapp/images/7.png)

![8](https://github.com/LQ55/AREASTATE/blob/master/src/main/webapp/images/8.png)

##### 这是一个angular+ui-router+requireJs+angularAMD+SSM为技术栈的小项目，如果对练手有帮助，给个star吧。^_^

^_^

^_^