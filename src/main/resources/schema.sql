--DROP SEQUENCE Sequence_member;
--
--DROP SEQUENCE Sequence_project;
--
--DROP SEQUENCE Sequence_task;
--
--DROP SEQUENCE Sequence_progress;
--
--DROP SEQUENCE Sequence_comments;
--
--DROP TABLE Progress CASCADE CONSTRAINTS PURGE;
--
--DROP TABLE Comments CASCADE CONSTRAINTS PURGE;
--
--DROP TABLE Task CASCADE CONSTRAINTS PURGE;
--
--DROP TABLE Participation CASCADE CONSTRAINTS PURGE;
--
--DROP TABLE Member CASCADE CONSTRAINTS PURGE;
--
--DROP TABLE Project CASCADE CONSTRAINTS PURGE;


CREATE SEQUENCE Sequence_member
	START WITH 10000;
    
CREATE SEQUENCE Sequence_project
	START WITH 100;

CREATE SEQUENCE Sequence_task
	START WITH 1000;

CREATE SEQUENCE Sequence_progress
	START WITH 100000;
    
CREATE SEQUENCE Sequence_comments
	START WITH 1000000;
    

CREATE TABLE Member
(
	member_id            INTEGER  NOT NULL ,
    user_name            VARCHAR2(15)  NOT NULL ,
	password             VARCHAR2(20)  NULL ,
	name                 VARCHAR2(10)  NULL ,
	email                VARCHAR2(30)  NULL ,
	phone                CHAR(13)  NULL ,
	birth                CHAR(8)  NULL 
);

CREATE UNIQUE INDEX XPKMember ON Member
(member_id   ASC);

ALTER TABLE Member
	ADD CONSTRAINT  XPKMember PRIMARY KEY (member_id);


CREATE TABLE Project
(
	project_id           INTEGER  NOT NULL ,
    leader_id            INTEGER  NOT NULL ,
	name                 VARCHAR2(40)  NULL ,
	type                 INTEGER  NULL ,
	creationDate         DATE  NULL ,
	createdLink          VARCHAR2(500)  NULL ,
	notice               VARCHAR2(300)  NULL ,
    color                CHAR(7) NULL
);

CREATE UNIQUE INDEX XPKProject ON Project
(project_id   ASC);

ALTER TABLE Project
	ADD CONSTRAINT  XPKProject PRIMARY KEY (project_id);


CREATE TABLE Participation
(
	project_id           INTEGER  NOT NULL ,
	member_id            INTEGER  NOT NULL 
);

CREATE UNIQUE INDEX XPKParticipation ON Participation
(project_id   ASC,member_id   ASC);

ALTER TABLE Participation
	ADD CONSTRAINT  XPKParticipation PRIMARY KEY (project_id,member_id);


CREATE TABLE Task
(
	task_id              INTEGER  NOT NULL ,
	task_progress        INT  NULL ,
	project_id           INTEGER  NOT NULL ,
	member_id            INTEGER  NOT NULL ,
	name                 VARCHAR2(30)  NULL ,
    content              VARCHAR2(90)  NULL ,
	deadline             DATE  NULL 
);

CREATE UNIQUE INDEX XPKTask ON Task
(task_id   ASC);

ALTER TABLE Task
	ADD CONSTRAINT  XPKTask PRIMARY KEY (task_id);


CREATE TABLE Progress
(
	progress_id          INTEGER  NOT NULL ,
	progress             NUMBER  NULL ,
	task_id              INTEGER  NOT NULL ,
	recordedDate         TIMESTAMP  NULL 
);

CREATE UNIQUE INDEX XPKProgress ON Progress
(progress_id   ASC);

ALTER TABLE Progress
	ADD CONSTRAINT  XPKProgress PRIMARY KEY (progress_id);


CREATE TABLE Comments
(
	comment_id           INTEGER  NOT NULL ,
	task_id              INTEGER  NOT NULL ,
	member_id            INTEGER  NOT NULL ,
	writtenDate          TIMESTAMP  NULL ,
	content              VARCHAR2(600)  NULL
);

CREATE UNIQUE INDEX XPKComments ON Comments
(comment_id   ASC);

ALTER TABLE Comments
	ADD CONSTRAINT  XPKComments PRIMARY KEY (comment_id);
    
    
ALTER TABLE Project
	ADD (
CONSTRAINT 관리 FOREIGN KEY (leader_id) REFERENCES Member (member_id));

ALTER TABLE Participation
	ADD (
CONSTRAINT 소유 FOREIGN KEY (project_id) REFERENCES Project (project_id));

ALTER TABLE Participation
	ADD (
CONSTRAINT 참여 FOREIGN KEY (member_id) REFERENCES Member (member_id));

ALTER TABLE Task
	ADD (
CONSTRAINT 소속 FOREIGN KEY (project_id) REFERENCES Project (project_id));

ALTER TABLE Task
	ADD (
CONSTRAINT 배정 FOREIGN KEY (member_id) REFERENCES Member (member_id));

ALTER TABLE Progress
	ADD (
CONSTRAINT 진행 FOREIGN KEY (task_id) REFERENCES Task (task_id));

ALTER TABLE Comments
	ADD (
CONSTRAINT 작성 FOREIGN KEY (task_id) REFERENCES Task (task_id));

ALTER TABLE Comments
	ADD (
CONSTRAINT 생성 FOREIGN KEY (member_id) REFERENCES Member (member_id));


--INSERT INTO MEMBER (member_id, user_name, password, name, email, phone, birth)
--    VALUES (SEQUENCE_MEMBER.nextval, '', '', '', '', '', '');
--INSERT INTO PROJECT (PROJECT_ID, leader_id, NAME, TYPE, CREATIONDATE, CREATEDLINK, NOTICE, COLOR)
--    VALUES (SEQUENCE_PROJECT.nextval, , '', , , '', '', '');
--INSERT INTO participation (project_id, member_id) VALUES (, );
--INSERT INTO TASK (task_id, task_progress, project_id, member_id, name, content, deadline)
--     VALUES (SEQUENCE_TASK.nextval, , , , '', '', '');
--INSERT INTO COMMENTS (comment_id, writtendate, content, task_id, member_id)
--    VALUES (SEQUENCE_COMMENTS.nextval, , '', , );

