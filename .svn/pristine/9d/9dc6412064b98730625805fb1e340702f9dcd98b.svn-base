if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Answer') and o.name = 'FK_ANSWER_REFERENCE_QUESTION')
alter table Answer
   drop constraint FK_ANSWER_REFERENCE_QUESTION
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Answer') and o.name = 'FK_ANSWER_REFERENCE_USERINFO')
alter table Answer
   drop constraint FK_ANSWER_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Attachment') and o.name = 'FK_ATTACHME_REFERENCE_ATTACH_STATUS')
alter table Attachment
   drop constraint FK_ATTACHME_REFERENCE_ATTACH_STATUS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Attachment') and o.name = 'FK_ATTACHME_REFERENCE_USERINFO')
alter table Attachment
   drop constraint FK_ATTACHME_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Audit') and o.name = 'FK_AUDIT_REFERENCE_USERINFO')
alter table Audit
   drop constraint FK_AUDIT_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Blog') and o.name = 'FK_BLOG_REFERENCE_USERINFO')
alter table Blog
   drop constraint FK_BLOG_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('BlogHIS') and o.name = 'FK_BLOGHIS_FK_BLOGHI_USERINFO')
alter table BlogHIS
   drop constraint FK_BLOGHIS_FK_BLOGHI_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('BlogHIS') and o.name = 'FK_BLOGHIS_REFERENCE_BLOGLOG')
alter table BlogHIS
   drop constraint FK_BLOGHIS_REFERENCE_BLOGLOG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('BlogLabel') and o.name = 'FK_BLOGLABE_FK_BLOGLA_BLOGLOG')
alter table BlogLabel
   drop constraint FK_BLOGLABE_FK_BLOGLA_BLOGLOG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('BlogLabel') and o.name = 'FK_BLOGLABE_FK_BLOGLA_LABEL')
alter table BlogLabel
   drop constraint FK_BLOGLABE_FK_BLOGLA_LABEL
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('BlogLog') and o.name = 'FK_BLOGLOG_REFERENCE_BLOG')
alter table BlogLog
   drop constraint FK_BLOGLOG_REFERENCE_BLOG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('BlogLog') and o.name = 'FK_BLOGLOG_REFERENCE_BLOGSTAT')
alter table BlogLog
   drop constraint FK_BLOGLOG_REFERENCE_BLOGSTAT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('BlogLog') and o.name = 'FK_BLOGLOG_REFERENCE_BOARD')
alter table BlogLog
   drop constraint FK_BLOGLOG_REFERENCE_BOARD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Favorites') and o.name = 'FK_FAVORITE_REFERENCE_BLOGLOG')
alter table Favorites
   drop constraint FK_FAVORITE_REFERENCE_BLOGLOG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Favorites') and o.name = 'FK_FAVORITE_REFERENCE_USERINFO')
alter table Favorites
   drop constraint FK_FAVORITE_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ForumLabel') and o.name = 'FK_FORUMLAB_FK_FORUML_FORUMPOS')
alter table ForumLabel
   drop constraint FK_FORUMLAB_FK_FORUML_FORUMPOS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ForumLabel') and o.name = 'FK_FORUMLAB_FK_FORUML_LABEL')
alter table ForumLabel
   drop constraint FK_FORUMLAB_FK_FORUML_LABEL
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ForumPost') and o.name = 'FK_FORUM_P_REFERENCE_BOARD')
alter table ForumPost
   drop constraint FK_FORUM_P_REFERENCE_BOARD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ForumPost') and o.name = 'FK_FORUM_P_REFERENCE_P_S')
alter table ForumPost
   drop constraint FK_FORUM_P_REFERENCE_P_S
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ForumPost') and o.name = 'FK_FORUM_P_REFERENCE_USERINFO')
alter table ForumPost
   drop constraint FK_FORUM_P_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ForumReply') and o.name = 'FK_FORUMREP_REFERENCE_POSTSTAT')
alter table ForumReply
   drop constraint FK_FORUMREP_REFERENCE_POSTSTAT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ForumReply') and o.name = 'FK_FORUMREP_REFERENCE_FORUMPOS')
alter table ForumReply
   drop constraint FK_FORUMREP_REFERENCE_FORUMPOS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ForumReply') and o.name = 'FK_FORUM_R_REFERENCE_USERINFO')
alter table ForumReply
   drop constraint FK_FORUM_R_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ForumTP') and o.name = 'FK_FORUMTP_FK_FORUMT_FORUMPOS')
alter table ForumTP
   drop constraint FK_FORUMTP_FK_FORUMT_FORUMPOS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ForumUpHis') and o.name = 'FK_FORUMUPH_FK_FORUMU_FORUMPOS')
alter table ForumUpHis
   drop constraint FK_FORUMUPH_FK_FORUMU_FORUMPOS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ForumUpHis') and o.name = 'FK_FORUMUPH_FK_FORUMU_USERINFO')
alter table ForumUpHis
   drop constraint FK_FORUMUPH_FK_FORUMU_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Friend') and o.name = 'FK_FRIEND_REFERENCE_GUEST')
alter table Friend
   drop constraint FK_FRIEND_REFERENCE_GUEST
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Friend') and o.name = 'FK_FRIEND_REFERENCE_MASTER')
alter table Friend
   drop constraint FK_FRIEND_REFERENCE_MASTER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Label') and o.name = 'FK_LABEL_REFERENCE_BOARD')
alter table Label
   drop constraint FK_LABEL_REFERENCE_BOARD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MasterApply') and o.name = 'FK_MASTERAP_FK_MASTER_BOARD')
alter table MasterApply
   drop constraint FK_MASTERAP_FK_MASTER_BOARD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MasterApply') and o.name = 'FK_MASTERAP_FK_MASTER_USERINFO')
alter table MasterApply
   drop constraint FK_MASTERAP_FK_MASTER_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Masters') and o.name = 'FK_MASTERS_FK_MASTER_BOARD')
alter table Masters
   drop constraint FK_MASTERS_FK_MASTER_BOARD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Masters') and o.name = 'FK_MASTERS_REFERENCE_USERINFO')
alter table Masters
   drop constraint FK_MASTERS_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Message') and o.name = 'FK_MESSAGE_REFERENCE_MESSAGET')
alter table Message
   drop constraint FK_MESSAGE_REFERENCE_MESSAGET
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Message') and o.name = 'FK_MESSAGE_REFERENCE_USERINFO')
alter table Message
   drop constraint FK_MESSAGE_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Message') and o.name = 'FK_MESSAGE_REFERENCE_USERINFO1')
alter table Message
   drop constraint FK_MESSAGE_REFERENCE_USERINFO1
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Notice') and o.name = 'FK_NOTICE_FK_NOTICE_USERINFO')
alter table Notice
   drop constraint FK_NOTICE_FK_NOTICE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PersonalInfo') and o.name = 'FK_PERSONAL_FK_PERSON_USERINFO')
alter table PersonalInfo
   drop constraint FK_PERSONAL_FK_PERSON_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Question') and o.name = 'FK_QUESTION_REFERENCE_BOARD')
alter table Question
   drop constraint FK_QUESTION_REFERENCE_BOARD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Question') and o.name = 'FK_QUESTION_REFERENCE_USERINFO')
alter table Question
   drop constraint FK_QUESTION_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('QuestionLabel') and o.name = 'FK_QUESTION_FK_QUESTI_LABEL')
alter table QuestionLabel
   drop constraint FK_QUESTION_FK_QUESTI_LABEL
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('QuestionLabel') and o.name = 'FK_QUESTION_FK_QUESTI_QUESTION')
alter table QuestionLabel
   drop constraint FK_QUESTION_FK_QUESTI_QUESTION
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('QuestionPJ') and o.name = 'FK_QUESTIONPJ_REFERENCE_ANSWER')
alter table QuestionPJ
   drop constraint FK_QUESTIONPJ_REFERENCE_ANSWER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('QuestionPJ') and o.name = 'FK_QUESTIONPJ_REFERENCE_USERINFO')
alter table QuestionPJ
   drop constraint FK_QUESTIONPJ_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('RechargeHis') and o.name = 'FK_RECHARGE_REFERENCE_USERINFO')
alter table RechargeHis
   drop constraint FK_RECHARGE_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Suggestion') and o.name = 'FK_SUGGESTI_FK_SUGGES_USERINFO')
alter table Suggestion
   drop constraint FK_SUGGESTI_FK_SUGGES_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TPJL') and o.name = 'FK_TPJL_FK_TPJL_R_FORUMTP')
alter table TPJL
   drop constraint FK_TPJL_FK_TPJL_R_FORUMTP
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TPJL') and o.name = 'FK_TPJL_FK_TPJL_R_USERINFO')
alter table TPJL
   drop constraint FK_TPJL_FK_TPJL_R_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('UserAlbum') and o.name = 'FK_USER_ALBUM_REFERENCE_USERINFO')
alter table UserAlbum
   drop constraint FK_USER_ALBUM_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('UserAlbum') and o.name = 'FK_USER_ALBUM_REFERENCE_USER_PHOTO')
alter table UserAlbum
   drop constraint FK_USER_ALBUM_REFERENCE_USER_PHOTO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('UserAlbumPhoto') and o.name = 'FK_USER_PHOTO_REFERENCE_USER_ALBUM')
alter table UserAlbumPhoto
   drop constraint FK_USER_PHOTO_REFERENCE_USER_ALBUM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('UserInfo') and o.name = 'FK_USERINFO_REFERENCE_ROLE')
alter table UserInfo
   drop constraint FK_USERINFO_REFERENCE_ROLE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('UserSecurity') and o.name = 'FK_USERSECU_REFERENCE_USERINFO')
alter table UserSecurity
   drop constraint FK_USERSECU_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('UserUpHis') and o.name = 'FK_USERUPHI_FK_USERUP_BLOGLOG')
alter table UserUpHis
   drop constraint FK_USERUPHI_FK_USERUP_BLOGLOG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('UserUpHis') and o.name = 'FK_USERUPHI_FK_USERUP_USERINFO')
alter table UserUpHis
   drop constraint FK_USERUPHI_FK_USERUP_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('WealthBoard') and o.name = 'FK_WEALTHBO_FK_WEALTH_BOARD')
alter table WealthBoard
   drop constraint FK_WEALTHBO_FK_WEALTH_BOARD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('WealthBoard') and o.name = 'FK_WEALTHBO_REFERENCE_USERINFO')
alter table WealthBoard
   drop constraint FK_WEALTHBO_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('WealthTradeHis') and o.name = 'FK_WEALTHTR_REFERENCE_ATTACHME')
alter table WealthTradeHis
   drop constraint FK_WEALTHTR_REFERENCE_ATTACHME
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('WealthTradeHis') and o.name = 'FK_WEALTHTR_REFERENCE_USERINFO')
alter table WealthTradeHis
   drop constraint FK_WEALTHTR_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('WealthTradeHis') and o.name = 'FK_WEALTH_T_REFERENCE_USERINFO2')
alter table WealthTradeHis
   drop constraint FK_WEALTH_T_REFERENCE_USERINFO2
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('attachDownload') and o.name = 'FK_ATTACHDO_REFERENCE_ATTACHME')
alter table attachDownload
   drop constraint FK_ATTACHDO_REFERENCE_ATTACHME
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('attachDownload') and o.name = 'FK_ATTACHDO_REFERENCE_USERINFO')
alter table attachDownload
   drop constraint FK_ATTACHDO_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('photoPJ') and o.name = 'FK_PHOTOPJ_REFERENCE_USERINFO')
alter table photoPJ
   drop constraint FK_PHOTOPJ_REFERENCE_USERINFO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('photoPJ') and o.name = 'FK_PHOTOPJ_REFERENCE_USERALBU')
alter table photoPJ
   drop constraint FK_PHOTOPJ_REFERENCE_USERALBU
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Answer')
            and   type = 'U')
   drop table Answer
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AttachStatus')
            and   type = 'U')
   drop table AttachStatus
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Attachment')
            and   type = 'U')
   drop table Attachment
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Audit')
            and   type = 'U')
   drop table Audit
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Blog')
            and   type = 'U')
   drop table Blog
go

if exists (select 1
            from  sysobjects
           where  id = object_id('BlogHIS')
            and   type = 'U')
   drop table BlogHIS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('BlogLabel')
            and   type = 'U')
   drop table BlogLabel
go

if exists (select 1
            from  sysobjects
           where  id = object_id('BlogLog')
            and   type = 'U')
   drop table BlogLog
go

if exists (select 1
            from  sysobjects
           where  id = object_id('BlogStatus')
            and   type = 'U')
   drop table BlogStatus
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Board')
            and   type = 'U')
   drop table Board
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Favorites')
            and   type = 'U')
   drop table Favorites
go

if exists (select 1
            from  sysobjects
           where  id = object_id('FilterWords')
            and   type = 'U')
   drop table FilterWords
go

if exists (select 1
            from  sysobjects
           where  id = object_id('FlagHis')
            and   type = 'U')
   drop table FlagHis
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ForumLabel')
            and   type = 'U')
   drop table ForumLabel
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ForumPost')
            and   type = 'U')
   drop table ForumPost
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ForumReply')
            and   type = 'U')
   drop table ForumReply
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ForumTP')
            and   type = 'U')
   drop table ForumTP
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ForumUpHis')
            and   type = 'U')
   drop table ForumUpHis
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Friend')
            and   type = 'U')
   drop table Friend
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Label')
            and   type = 'U')
   drop table Label
go

if exists (select 1
            from  sysobjects
           where  id = object_id('MasterApply')
            and   type = 'U')
   drop table MasterApply
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Masters')
            and   type = 'U')
   drop table Masters
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Message')
            and   type = 'U')
   drop table Message
go

if exists (select 1
            from  sysobjects
           where  id = object_id('MessageText')
            and   type = 'U')
   drop table MessageText
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Notice')
            and   type = 'U')
   drop table Notice
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PersonalInfo')
            and   type = 'U')
   drop table PersonalInfo
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PostStatus')
            and   type = 'U')
   drop table PostStatus
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Question')
            and   type = 'U')
   drop table Question
go

if exists (select 1
            from  sysobjects
           where  id = object_id('QuestionLabel')
            and   type = 'U')
   drop table QuestionLabel
go

if exists (select 1
            from  sysobjects
           where  id = object_id('QuestionPJ')
            and   type = 'U')
   drop table QuestionPJ
go

if exists (select 1
            from  sysobjects
           where  id = object_id('RechargeHis')
            and   type = 'U')
   drop table RechargeHis
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Role')
            and   type = 'U')
   drop table Role
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Suggestion')
            and   type = 'U')
   drop table Suggestion
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TPJL')
            and   type = 'U')
   drop table TPJL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('UserAlbum')
            and   type = 'U')
   drop table UserAlbum
go

if exists (select 1
            from  sysobjects
           where  id = object_id('UserAlbumPhoto')
            and   type = 'U')
   drop table UserAlbumPhoto
go

if exists (select 1
            from  sysobjects
           where  id = object_id('UserInfo')
            and   type = 'U')
   drop table UserInfo
go

if exists (select 1
            from  sysobjects
           where  id = object_id('UserSecurity')
            and   type = 'U')
   drop table UserSecurity
go

if exists (select 1
            from  sysobjects
           where  id = object_id('UserUpHis')
            and   type = 'U')
   drop table UserUpHis
go

if exists (select 1
            from  sysobjects
           where  id = object_id('WealthBoard')
            and   type = 'U')
   drop table WealthBoard
go

if exists (select 1
            from  sysobjects
           where  id = object_id('WealthTradeHis')
            and   type = 'U')
   drop table WealthTradeHis
go

if exists (select 1
            from  sysobjects
           where  id = object_id('attachDownload')
            and   type = 'U')
   drop table attachDownload
go

if exists (select 1
            from  sysobjects
           where  id = object_id('photoPJ')
            and   type = 'U')
   drop table photoPJ
go

/*==============================================================*/
/* Table: Answer                                                */
/*==============================================================*/
create table Answer (
   id                   numeric              identity,
   UserInfo_id          numeric              null,
   a_content            text                 null,
   a_time               varchar(80)          null,
   q_id                 numeric              null,
   up_count             varchar(25)          null,
   normal               varchar(25)          null,
   down                 varchar(25)          null,
   isPublic             varchar(25)          null,
   isReAsk              varchar(25)          null,
   Qcommit              varchar(25)          null,
   reCount              varchar(25)          null,
   related              varchar(25)          null,
   baochou              varchar(25)          null,
   constraint PK_ANSWER primary key (id)
)
go

/*==============================================================*/
/* Table: AttachStatus                                          */
/*==============================================================*/
create table AttachStatus (
   id                   numeric              identity,
   attach_status        varchar(25)          null,
   constraint PK_ATTACHSTATUS primary key (id)
)
go

/*==============================================================*/
/* Table: Attachment                                            */
/*==============================================================*/
create table Attachment (
   id                   numeric              identity,
   UserInfo_id          numeric              null,
   status_id            numeric              null,
   attach_url           varchar(400)         null,
   attach_name          varchar(80)          null,
   attach_desc          text                 null,
   attach_size          varchar(80)          null,
   jinzhuanWealth       varchar(25)          null,
   lingdanWealth        varchar(25)          null,
   up_count             varchar(25)          null,
   normal               varchar(25)          null,
   down                 varchar(25)          null,
   access               varchar(25)          null,
   attach_download      varchar(80)          null,
   attach_time          varchar(200)         null,
   constraint PK_ATTACHMENT primary key (id)
)
go

/*==============================================================*/
/* Table: Audit                                                 */
/*==============================================================*/
create table Audit (
   id                   numeric              identity,
   audit_user           numeric              null,
   audit_type           varchar(20)          null,
   audit_id             varchar(20)          null,
   audit_content        varchar(80)          null,
   audit_time           varchar(25)          null,
   constraint PK_AUDIT primary key (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '论坛/博客/照片/附件',
   'user', @CurrentUser, 'table', 'Audit', 'column', 'audit_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '各自所在表ID',
   'user', @CurrentUser, 'table', 'Audit', 'column', 'audit_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '描述',
   'user', @CurrentUser, 'table', 'Audit', 'column', 'audit_content'
go

/*==============================================================*/
/* Table: Blog                                                  */
/*==============================================================*/
create table Blog (
   id                   numeric              not null,
   visited              varchar(80)          null,
   blog_up              varchar(80)          null,
   blog_name            varchar(80)          null,
   blog_desc            varchar(80)          null,
   blog_Album           varchar(200)         null,
   constraint PK_BLOG primary key (id)
)
go

/*==============================================================*/
/* Table: BlogHIS                                               */
/*==============================================================*/
create table BlogHIS (
   id                   numeric              identity,
   User_id              numeric              null,
   Blo_id               numeric              null,
   time                 varchar(25)          null,
   constraint PK_BLOGHIS primary key (id)
)
go

/*==============================================================*/
/* Table: BlogLabel                                             */
/*==============================================================*/
create table BlogLabel (
   id                   numeric              identity,
   lab_id               numeric              null,
   blo_id               numeric              null,
   constraint PK_BLOGLABEL primary key (id)
)
go

/*==============================================================*/
/* Table: BlogLog                                               */
/*==============================================================*/
create table BlogLog (
   id                   numeric              identity,
   status_id            numeric              null,
   boa_id               numeric              null,
   blog_id              numeric              null,
   blog_type            varchar(80)          null,
   visited              varchar(80)          null,
   blog_time            varchar(20)          null,
   subject              varchar(200)         null,
   blog_content         text                 null,
   up                   varchar(80)          null,
   normal               varchar(80)          null,
   down                 varchar(80)          null,
   WZCC                 varchar(200)         null,
   SFZZ                 varchar(25)          null,
   process_user         varchar(80)          null,
   process_cause        varchar(400)         null,
   process_his          text                 null,
   process_time         varchar(25)          null,
   keywordA             varchar(40)          null,
   keywordB             varchar(40)          null,
   keywordC             varchar(40)          null,
   constraint PK_BLOGLOG primary key (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '原创/转载/译文
   ',
   'user', @CurrentUser, 'table', 'BlogLog', 'column', 'blog_type'
go

/*==============================================================*/
/* Table: BlogStatus                                            */
/*==============================================================*/
create table BlogStatus (
   id                   numeric              identity,
   status               varchar(400)         null,
   constraint PK_BLOGSTATUS primary key (id)
)
go

/*==============================================================*/
/* Table: Board                                                 */
/*==============================================================*/
create table Board (
   id                   numeric              identity,
   board_name           varchar(400)         null,
   board_desc           text                 null,
   board_pic            varchar(200)         null,
   isVerify             varchar(25)          null,
   constraint PK_BOARD primary key (id)
)
go

/*==============================================================*/
/* Table: Favorites                                             */
/*==============================================================*/
create table Favorites (
   id                   numeric              identity,
   UserInfo_id          numeric              null,
   blog_name            numeric              null,
   blog_url             varchar(80)          null,
   time                 varchar(25)          null,
   constraint PK_FAVORITES primary key (id)
)
go

/*==============================================================*/
/* Table: FilterWords                                           */
/*==============================================================*/
create table FilterWords (
   id                   numeric              identity,
   find                 varchar(200)         null,
   replacement          varchar(200)         null,
   constraint PK_FILTERWORDS primary key (id)
)
go

/*==============================================================*/
/* Table: FlagHis                                               */
/*==============================================================*/
create table FlagHis (
   id                   numeric              identity,
   re_user              varchar(80)          null,
   re_desc              varchar(80)          null,
   re_cause             varchar(80)          null,
   re_time              varchar(80)          null,
   do_user              varchar(80)          null,
   do_way               varchar(80)          null,
   do_time              varchar(80)          null,
   do_URL               varchar(80)          null,
   constraint PK_FLAGHIS primary key (id)
)
go

/*==============================================================*/
/* Table: ForumLabel                                            */
/*==============================================================*/
create table ForumLabel (
   id                   numeric              identity,
   For_id               numeric              null,
   lab_id               numeric              null,
   constraint PK_FORUMLABEL primary key (id)
)
go

/*==============================================================*/
/* Table: ForumPost                                             */
/*==============================================================*/
create table ForumPost (
   id                   numeric              identity,
   subject              varchar(400)         null,
   UserInfo_id          numeric              null,
   status_id            numeric              null,
   boa_id               numeric              null,
   post_date            varchar(400)         null,
   post_content         text                 null,
   reply_count          varchar(400)         null,
   isTop                varchar(25)          null,
   isWell               varchar(25)          null,
   post_count           varchar(25)          null,
   process_user         varchar(25)          null,
   process_time         varchar(25)          null,
   process_cause        varchar(80)          null,
   process_his          text                 null,
   reply_access         varchar(25)          null,
   reply_time           varchar(25)          null,
   post_type            varchar(25)          null,
   keywordA             varchar(40)          null,
   keywordB             varchar(40)          null,
   keywordC             varchar(40)          null,
   constraint PK_FORUMPOST primary key (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '0 不置顶
   1 置顶',
   'user', @CurrentUser, 'table', 'ForumPost', 'column', 'isTop'
go

/*==============================================================*/
/* Table: ForumReply                                            */
/*==============================================================*/
create table ForumReply (
   id                   numeric              identity,
   UserInfo_id          numeric              null,
   status_id            numeric              null,
   post_id              numeric              null,
   reply_content        text                 null,
   reply_time           varchar(25)          null,
   process_user         varchar(25)          null,
   process_time         varchar(25)          null,
   process_cause        varchar(80)          null,
   process_his          text                 null,
   up                   varchar(80)          null,
   normal               varchar(80)          null,
   down                 varchar(80)          null,
   constraint PK_FORUMREPLY primary key (id)
)
go

/*==============================================================*/
/* Table: ForumTP                                               */
/*==============================================================*/
create table ForumTP (
   id                   numeric              identity,
   For_id               numeric              null,
   TPsubject            varchar(80)          null,
   TPcount              varchar(80)          null,
   beginTime            varchar(80)          null,
   endTime              varchar(80)          null,
   other                varchar(80)          null,
   constraint PK_FORUMTP primary key (id)
)
go

/*==============================================================*/
/* Table: ForumUpHis                                            */
/*==============================================================*/
create table ForumUpHis (
   id                   numeric              identity,
   Use_id               numeric              null,
   For_id               numeric              null,
   UpTime               varchar(80)          null,
   UpContent            text                 null,
   constraint PK_FORUMUPHIS primary key (id)
)
go

/*==============================================================*/
/* Table: Friend                                                */
/*==============================================================*/
create table Friend (
   id                   numeric              identity,
   msater_id            numeric              null,
   guest_id             numeric              null,
   constraint PK_FRIEND primary key (id)
)
go

/*==============================================================*/
/* Table: Label                                                 */
/*==============================================================*/
create table Label (
   id                   numeric              identity,
   boa_id               numeric              null,
   label_name           varchar(400)         null,
   label_desc           text                 null,
   label_pic            varchar(40)          null,
   constraint PK_LABEL primary key (id)
)
go

/*==============================================================*/
/* Table: MasterApply                                           */
/*==============================================================*/
create table MasterApply (
   id                   numeric              identity,
   Use_id               numeric              null,
   boa_id               numeric              null,
   apply_desc           text                 null,
   time                 varchar(80)          null,
   constraint PK_MASTERAPPLY primary key (id)
)
go

/*==============================================================*/
/* Table: Masters                                               */
/*==============================================================*/
create table Masters (
   id                   numeric              identity,
   UserInfo_id          numeric              null,
   boa_id               numeric              null,
   MasterExplain        text                 null,
   constraint PK_MASTERS primary key (id)
)
go

/*==============================================================*/
/* Table: Message                                               */
/*==============================================================*/
create table Message (
   id                   numeric              identity,
   Send_id              numeric              null,
   Msg_id               numeric              null,
   Rec_id               numeric              null,
   isRead               varchar(25)          null,
   constraint PK_MESSAGE primary key (id)
)
go

/*==============================================================*/
/* Table: MessageText                                           */
/*==============================================================*/
create table MessageText (
   id                   numeric              identity,
   msg_content          text                 null,
   msg_time             varchar(40)          null,
   msg_type             varchar(25)          null,
   msg_subject          varchar(200)         null,
   constraint PK_MESSAGETEXT primary key (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '申请，举报，一般',
   'user', @CurrentUser, 'table', 'MessageText', 'column', 'msg_type'
go

/*==============================================================*/
/* Table: Notice                                                */
/*==============================================================*/
create table Notice (
   id                   numeric              identity,
   Use_id               numeric              null,
   noticeSubject        varchar(80)          null,
   noticeContent        text                 null,
   noticeTime           varchar(80)          null,
   noticeType           varchar(25)          null,
   noticePlace          varchar(25)          null,
   constraint PK_NOTICE primary key (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '留以备用',
   'user', @CurrentUser, 'table', 'Notice', 'column', 'noticePlace'
go

/*==============================================================*/
/* Table: PersonalInfo                                          */
/*==============================================================*/
create table PersonalInfo (
   id                   numeric              not null,
   sex                  varchar(80)          null,
   birthday             varchar(80)          null,
   personal_desc        text                 null,
   realname             varchar(80)          null,
   idno                 varchar(80)          null,
   shengao              varchar(80)          null,
   aihao                varchar(80)          null,
   shanchang            varchar(80)          null,
   jiguan               varchar(80)          null,
   address              varchar(80)          null,
   hangye               varchar(80)          null,
   company              varchar(80)          null,
   job                  varchar(80)          null,
   graduate             varchar(80)          null,
   zhuanye              varchar(80)          null,
   degree               varchar(80)          null,
   xueli                varchar(80)          null,
   constraint PK_PERSONALINFO primary key (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '单位厘米',
   'user', @CurrentUser, 'table', 'PersonalInfo', 'column', 'shengao'
go

/*==============================================================*/
/* Table: PostStatus                                            */
/*==============================================================*/
create table PostStatus (
   id                   numeric              identity,
   status               varchar(400)         null,
   constraint PK_POSTSTATUS primary key (id)
)
go

/*==============================================================*/
/* Table: Question                                              */
/*==============================================================*/
create table Question (
   id                   numeric              identity,
   UserInfo_id          numeric              null,
   boa_id               numeric              null,
   q_subject            varchar(80)          null,
   q_content            text                 null,
   q_time               varchar(80)          null,
   q_access             varchar(80)          null,
   value                varchar(25)          null,
   chargeType           varchar(25)          null,
   hiddenUser           varchar(25)          null,
   keywordA             varchar(40)          null,
   keywordB             varchar(40)          null,
   keywordC             varchar(40)          null,
   constraint PK_QUESTION primary key (id)
)
go

/*==============================================================*/
/* Table: QuestionLabel                                         */
/*==============================================================*/
create table QuestionLabel (
   Que_id               numeric              null,
   id                   numeric              identity,
   lab_id               numeric              null,
   constraint PK_QUESTIONLABEL primary key (id)
)
go

/*==============================================================*/
/* Table: QuestionPJ                                            */
/*==============================================================*/
create table QuestionPJ (
   id                   numeric              identity,
   Ans_id               numeric              null,
   Use_id               numeric              null,
   commitType           varchar(25)          null,
   constraint PK_QUESTIONPJ primary key (id)
)
go

/*==============================================================*/
/* Table: RechargeHis                                           */
/*==============================================================*/
create table RechargeHis (
   id                   numeric              identity,
   UserInfo_id          numeric              null,
   value                varchar(25)          null,
   time                 varchar(25)          null,
   constraint PK_RECHARGEHIS primary key (id)
)
go

/*==============================================================*/
/* Table: Role                                                  */
/*==============================================================*/
create table Role (
   id                   numeric              identity,
   role                 varchar(400)         not null,
   role_desc            text                 null,
   constraint PK_ROLE primary key (id)
)
go

/*==============================================================*/
/* Table: Suggestion                                            */
/*==============================================================*/
create table Suggestion (
   id                   numeric              identity,
   Use_id               numeric              null,
   suggestTime          varchar(80)          null,
   suggestContent       text                 null,
   constraint PK_SUGGESTION primary key (id)
)
go

/*==============================================================*/
/* Table: TPJL                                                  */
/*==============================================================*/
create table TPJL (
   id                   numeric              identity,
   For_id               numeric              null,
   Use_id               numeric              null,
   constraint PK_TPJL primary key (id)
)
go

/*==============================================================*/
/* Table: UserAlbum                                             */
/*==============================================================*/
create table UserAlbum (
   id                   numeric              identity,
   UserInfo_id          numeric              null,
   cover_id             numeric              null,
   album_name           varchar(20)          null,
   album_desc           text                 null,
   album_date           varchar(200)         null,
   islocked             varchar(20)          null,
   album_password       varchar(200)         null,
   constraint PK_USERALBUM primary key (id)
)
go

/*==============================================================*/
/* Table: UserAlbumPhoto                                        */
/*==============================================================*/
create table UserAlbumPhoto (
   id                   numeric              identity,
   album_id             numeric              null,
   photo                varchar(400)         null,
   photo_desc           text                 null,
   photo_time           varchar(25)          null,
   up                   varchar(25)          null,
   normal               varchar(25)          null,
   down                 varchar(25)          null,
   ZZZM                 varchar(25)          null,
   root                 varchar(25)          null,
   constraint PK_USERALBUMPHOTO primary key (id)
)
go

/*==============================================================*/
/* Table: UserInfo                                              */
/*==============================================================*/
create table UserInfo (
   id                   numeric              identity,
   Rol_id               numeric              null,
   UserName             varchar(400)         null,
   Password             varchar(400)         null,
   nickName             varchar(400)         null,
   head_img             varchar(400)         null,
   user_status          varchar(25)          null,
   register_date        varchar(40)          null,
   LastLogin_date       varchar(40)          null,
   "E-mail"             varchar(40)          null,
   isBreak              varchar(25)          null,
   user_level           varchar(25)          null,
   User_show            varchar(50)          null,
   isSay                varchar(80)          null,
   xianhua              varchar(25)          null,
   yangmu               varchar(25)          null,
   jinzhuan             varchar(80)          null,
   lingdan              varchar(80)          null,
   constraint PK_USERINFO primary key (id)
)
go

/*==============================================================*/
/* Table: UserSecurity                                          */
/*==============================================================*/
create table UserSecurity (
   id                   numeric              identity,
   UserInfo_id          numeric              null,
   question1            varchar(400)         null,
   question2            varchar(400)         null,
   question3            varchar(400)         null,
   answer1              varchar(400)         null,
   answer2              varchar(400)         null,
   answer3              varchar(400)         null,
   constraint PK_USERSECURITY primary key (id)
)
go

/*==============================================================*/
/* Table: UserUpHis                                             */
/*==============================================================*/
create table UserUpHis (
   id                   numeric              identity,
   User_id              numeric              null,
   blog_id              numeric              null,
   time                 varchar(80)          null,
   constraint PK_USERUPHIS primary key (id)
)
go

/*==============================================================*/
/* Table: WealthBoard                                           */
/*==============================================================*/
create table WealthBoard (
   id                   numeric              identity,
   UserInfo_id          numeric              null,
   boa_id               numeric              null,
   wealth_quantity      varchar(80)          null,
   constraint PK_WEALTHBOARD primary key (id)
)
go

/*==============================================================*/
/* Table: WealthTradeHis                                        */
/*==============================================================*/
create table WealthTradeHis (
   id                   numeric              identity,
   seller_id            numeric              null,
   Attach_id            numeric              null,
   buyer_id2            numeric              null,
   constraint PK_WEALTHTRADEHIS primary key (id)
)
go

/*==============================================================*/
/* Table: attachDownload                                        */
/*==============================================================*/
create table attachDownload (
   id                   numeric              identity,
   Use_id               numeric              null,
   Att_id               numeric              null,
   time                 varchar(80)          null,
   constraint PK_ATTACHDOWNLOAD primary key (id)
)
go

/*==============================================================*/
/* Table: photoPJ                                               */
/*==============================================================*/
create table photoPJ (
   photo_id             numeric              null,
   time                 varchar(80)          null,
   user_id              numeric              null,
   id                   numeric              identity,
   constraint PK_PHOTOPJ primary key (id)
)
go

alter table Answer
   add constraint FK_ANSWER_REFERENCE_QUESTION foreign key (q_id)
      references Question (id)
go

alter table Answer
   add constraint FK_ANSWER_REFERENCE_USERINFO foreign key (UserInfo_id)
      references UserInfo (id)
go

alter table Attachment
   add constraint FK_ATTACHME_REFERENCE_ATTACH_STATUS foreign key (status_id)
      references AttachStatus (id)
go

alter table Attachment
   add constraint FK_ATTACHME_REFERENCE_USERINFO foreign key (UserInfo_id)
      references UserInfo (id)
go

alter table Audit
   add constraint FK_AUDIT_REFERENCE_USERINFO foreign key (audit_user)
      references UserInfo (id)
go

alter table Blog
   add constraint FK_BLOG_REFERENCE_USERINFO foreign key (id)
      references UserInfo (id)
go

alter table BlogHIS
   add constraint FK_BLOGHIS_FK_BLOGHI_USERINFO foreign key (User_id)
      references UserInfo (id)
go

alter table BlogHIS
   add constraint FK_BLOGHIS_REFERENCE_BLOGLOG foreign key (Blo_id)
      references BlogLog (id)
go

alter table BlogLabel
   add constraint FK_BLOGLABE_FK_BLOGLA_BLOGLOG foreign key (blo_id)
      references BlogLog (id)
go

alter table BlogLabel
   add constraint FK_BLOGLABE_FK_BLOGLA_LABEL foreign key (lab_id)
      references Label (id)
go

alter table BlogLog
   add constraint FK_BLOGLOG_REFERENCE_BLOG foreign key (blog_id)
      references Blog (id)
go

alter table BlogLog
   add constraint FK_BLOGLOG_REFERENCE_BLOGSTAT foreign key (status_id)
      references BlogStatus (id)
go

alter table BlogLog
   add constraint FK_BLOGLOG_REFERENCE_BOARD foreign key (boa_id)
      references Board (id)
go

alter table Favorites
   add constraint FK_FAVORITE_REFERENCE_BLOGLOG foreign key (blog_name)
      references BlogLog (id)
go

alter table Favorites
   add constraint FK_FAVORITE_REFERENCE_USERINFO foreign key (UserInfo_id)
      references UserInfo (id)
go

alter table ForumLabel
   add constraint FK_FORUMLAB_FK_FORUML_FORUMPOS foreign key (For_id)
      references ForumPost (id)
go

alter table ForumLabel
   add constraint FK_FORUMLAB_FK_FORUML_LABEL foreign key (lab_id)
      references Label (id)
go

alter table ForumPost
   add constraint FK_FORUM_P_REFERENCE_BOARD foreign key (boa_id)
      references Board (id)
go

alter table ForumPost
   add constraint FK_FORUM_P_REFERENCE_P_S foreign key (status_id)
      references PostStatus (id)
go

alter table ForumPost
   add constraint FK_FORUM_P_REFERENCE_USERINFO foreign key (UserInfo_id)
      references UserInfo (id)
go

alter table ForumReply
   add constraint FK_FORUMREP_REFERENCE_POSTSTAT foreign key (status_id)
      references PostStatus (id)
go

alter table ForumReply
   add constraint FK_FORUMREP_REFERENCE_FORUMPOS foreign key (post_id)
      references ForumPost (id)
go

alter table ForumReply
   add constraint FK_FORUM_R_REFERENCE_USERINFO foreign key (UserInfo_id)
      references UserInfo (id)
go

alter table ForumTP
   add constraint FK_FORUMTP_FK_FORUMT_FORUMPOS foreign key (For_id)
      references ForumPost (id)
go

alter table ForumUpHis
   add constraint FK_FORUMUPH_FK_FORUMU_FORUMPOS foreign key (For_id)
      references ForumPost (id)
go

alter table ForumUpHis
   add constraint FK_FORUMUPH_FK_FORUMU_USERINFO foreign key (Use_id)
      references UserInfo (id)
go

alter table Friend
   add constraint FK_FRIEND_REFERENCE_GUEST foreign key (guest_id)
      references UserInfo (id)
go

alter table Friend
   add constraint FK_FRIEND_REFERENCE_MASTER foreign key (msater_id)
      references UserInfo (id)
go

alter table Label
   add constraint FK_LABEL_REFERENCE_BOARD foreign key (boa_id)
      references Board (id)
go

alter table MasterApply
   add constraint FK_MASTERAP_FK_MASTER_BOARD foreign key (boa_id)
      references Board (id)
go

alter table MasterApply
   add constraint FK_MASTERAP_FK_MASTER_USERINFO foreign key (Use_id)
      references UserInfo (id)
go

alter table Masters
   add constraint FK_MASTERS_FK_MASTER_BOARD foreign key (boa_id)
      references Board (id)
go

alter table Masters
   add constraint FK_MASTERS_REFERENCE_USERINFO foreign key (UserInfo_id)
      references UserInfo (id)
go

alter table Message
   add constraint FK_MESSAGE_REFERENCE_MESSAGET foreign key (Msg_id)
      references MessageText (id)
go

alter table Message
   add constraint FK_MESSAGE_REFERENCE_USERINFO foreign key (Rec_id)
      references UserInfo (id)
go

alter table Message
   add constraint FK_MESSAGE_REFERENCE_USERINFO1 foreign key (Send_id)
      references UserInfo (id)
go

alter table Notice
   add constraint FK_NOTICE_FK_NOTICE_USERINFO foreign key (Use_id)
      references UserInfo (id)
go

alter table PersonalInfo
   add constraint FK_PERSONAL_FK_PERSON_USERINFO foreign key (id)
      references UserInfo (id)
go

alter table Question
   add constraint FK_QUESTION_REFERENCE_BOARD foreign key (boa_id)
      references Board (id)
go

alter table Question
   add constraint FK_QUESTION_REFERENCE_USERINFO foreign key (UserInfo_id)
      references UserInfo (id)
go

alter table QuestionLabel
   add constraint FK_QUESTION_FK_QUESTI_LABEL foreign key (lab_id)
      references Label (id)
go

alter table QuestionLabel
   add constraint FK_QUESTION_FK_QUESTI_QUESTION foreign key (Que_id)
      references Question (id)
go

alter table QuestionPJ
   add constraint FK_QUESTIONPJ_REFERENCE_ANSWER foreign key (Ans_id)
      references Answer (id)
go

alter table QuestionPJ
   add constraint FK_QUESTIONPJ_REFERENCE_USERINFO foreign key (Use_id)
      references UserInfo (id)
go

alter table RechargeHis
   add constraint FK_RECHARGE_REFERENCE_USERINFO foreign key (UserInfo_id)
      references UserInfo (id)
go

alter table Suggestion
   add constraint FK_SUGGESTI_FK_SUGGES_USERINFO foreign key (Use_id)
      references UserInfo (id)
go

alter table TPJL
   add constraint FK_TPJL_FK_TPJL_R_FORUMTP foreign key (For_id)
      references ForumTP (id)
go

alter table TPJL
   add constraint FK_TPJL_FK_TPJL_R_USERINFO foreign key (Use_id)
      references UserInfo (id)
go

alter table UserAlbum
   add constraint FK_USER_ALBUM_REFERENCE_USERINFO foreign key (UserInfo_id)
      references UserInfo (id)
go

alter table UserAlbum
   add constraint FK_USER_ALBUM_REFERENCE_USER_PHOTO foreign key (cover_id)
      references UserAlbumPhoto (id)
go

alter table UserAlbumPhoto
   add constraint FK_USER_PHOTO_REFERENCE_USER_ALBUM foreign key (album_id)
      references UserAlbum (id)
go

alter table UserInfo
   add constraint FK_USERINFO_REFERENCE_ROLE foreign key (Rol_id)
      references Role (id)
go

alter table UserSecurity
   add constraint FK_USERSECU_REFERENCE_USERINFO foreign key (UserInfo_id)
      references UserInfo (id)
go

alter table UserUpHis
   add constraint FK_USERUPHI_FK_USERUP_BLOGLOG foreign key (blog_id)
      references BlogLog (id)
go

alter table UserUpHis
   add constraint FK_USERUPHI_FK_USERUP_USERINFO foreign key (User_id)
      references UserInfo (id)
go

alter table WealthBoard
   add constraint FK_WEALTHBO_FK_WEALTH_BOARD foreign key (boa_id)
      references Board (id)
go

alter table WealthBoard
   add constraint FK_WEALTHBO_REFERENCE_USERINFO foreign key (UserInfo_id)
      references UserInfo (id)
go

alter table WealthTradeHis
   add constraint FK_WEALTHTR_REFERENCE_ATTACHME foreign key (Attach_id)
      references Attachment (id)
go

alter table WealthTradeHis
   add constraint FK_WEALTHTR_REFERENCE_USERINFO foreign key (buyer_id2)
      references UserInfo (id)
go

alter table WealthTradeHis
   add constraint FK_WEALTH_T_REFERENCE_USERINFO2 foreign key (seller_id)
      references UserInfo (id)
go

alter table attachDownload
   add constraint FK_ATTACHDO_REFERENCE_ATTACHME foreign key (Att_id)
      references Attachment (id)
go

alter table attachDownload
   add constraint FK_ATTACHDO_REFERENCE_USERINFO foreign key (Use_id)
      references UserInfo (id)
go

alter table photoPJ
   add constraint FK_PHOTOPJ_REFERENCE_USERINFO foreign key (user_id)
      references UserInfo (id)
go

alter table photoPJ
   add constraint FK_PHOTOPJ_REFERENCE_USERALBU foreign key (photo_id)
      references UserAlbumPhoto (id)
go
