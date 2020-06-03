IF OBJECT_ID ('dbo.comm_id_card') IS NOT NULL
	DROP TABLE dbo.comm_id_card
GO

CREATE TABLE dbo.comm_id_card
	(
	id             INT IDENTITY NOT NULL,
	id_type        VARCHAR (20) NULL,
	id_card        VARCHAR (18) NOT NULL,
	name           VARCHAR (100) NULL,
	gender         VARCHAR (2) NULL,
	birthday       DATE NULL,
	nation         VARCHAR (20) NULL,
	address        VARCHAR (500) NULL,
	effective_date DATE NULL,
	expired_date   DATE NULL,
	sign_office    VARCHAR (200) NULL,
	timestamp      DATETIME CONSTRAINT DF__comm_id_c__times__009508B4 DEFAULT (getdate()) NOT NULL,
	CONSTRAINT id_card PRIMARY KEY NONCLUSTERED (id_card)
	)
GO

IF OBJECT_ID ('dbo.comm_mail_template') IS NOT NULL
	DROP TABLE dbo.comm_mail_template
GO

CREATE TABLE dbo.comm_mail_template
	(
	id                INT IDENTITY NOT NULL,
	template_name     NVARCHAR (200) NOT NULL,
	template_title    TEXT NULL,
	template_desc     TEXT NULL,
	mail_subject      TEXT NULL,
	mail_sender       TEXT NULL,
	mail_recievers    TEXT NULL,
	mail_cc_recievers TEXT NULL,
	mail_body         TEXT NULL,
	module_code       NVARCHAR (60) NULL,
	user_id           NVARCHAR (200) NULL,
	timestamp         DATETIME DEFAULT (getdate()) NOT NULL,
	PRIMARY KEY (template_name)
	)
GO

IF OBJECT_ID ('dbo.comm_reference') IS NOT NULL
	DROP TABLE dbo.comm_reference
GO

CREATE TABLE dbo.comm_reference
	(
	id          INT IDENTITY NOT NULL,
	type        VARCHAR (90) NULL,
	code        VARCHAR (200) NULL,
	language_id VARCHAR (20) NULL,
	category_cd VARCHAR (150) NULL,
	code_desc   NVARCHAR (500) NULL,
	last_value  INT NULL,
	span        INT CONSTRAINT DF__comm_refer__span__02BD4848 DEFAULT ((1)) NULL,
	remarks     VARCHAR (500) NULL,
	timestamp   DATETIME CONSTRAINT DF__comm_refe__times__03B16C81 DEFAULT (getdate()) NOT NULL,
	CONSTRAINT PK__comm_ref__3213E83F852DBD7D PRIMARY KEY (id)
	)
GO

CREATE UNIQUE INDEX indx_reference_constraint
	ON dbo.comm_reference (code, type, language_id)
GO

IF OBJECT_ID ('dbo.comm_sys_user') IS NOT NULL
	DROP TABLE dbo.comm_sys_user
GO

CREATE TABLE dbo.comm_sys_user
	(
	user_name         VARCHAR (100) NOT NULL,
	password          VARCHAR (100) NOT NULL,
	id_type           VARCHAR (20) NULL,
	id_card           VARCHAR (18) NULL,
	email             VARCHAR (50) NULL,
	phone             VARCHAR (20) NULL,
	gender            VARCHAR (2) NULL,
	verify_ind        VARCHAR (1) CONSTRAINT DF__comm_sys___verif__7ADC2F5E DEFAULT ('N') NOT NULL,
	pass_expire_date  DATETIME NULL,
	login_wrong_times INT CONSTRAINT DF__comm_sys___login__7BD05397 DEFAULT ('0') NOT NULL,
	lock_ind          CHAR (1) CONSTRAINT DF__comm_sys___lock___7CC477D0 DEFAULT ('N') NULL,
	password_his      VARCHAR (600) NULL,
	lock_date         DATETIME NULL,
	address           VARCHAR (500) NULL,
	remarks           VARCHAR (500) NULL,
	timestamp         DATETIME CONSTRAINT DF__comm_sys___times__7DB89C09 DEFAULT (getdate()) NOT NULL,
	CONSTRAINT user_name PRIMARY KEY NONCLUSTERED (user_name)
	)
GO

IF OBJECT_ID ('dbo.comm_task') IS NOT NULL
	DROP TABLE dbo.comm_task
GO

CREATE TABLE dbo.comm_task
	(
	id               INT IDENTITY NOT NULL,
	task_no          VARCHAR (50) NOT NULL,
	task_type        VARCHAR (50) NULL,
	task_subject     VARCHAR (200) NULL,
	task_content     TEXT NULL,
	system_name      VARCHAR (100) NULL,
	estimated_effort DECIMAL (12, 2) NULL,
	actual_effort    DECIMAL (12, 2) NULL,
	assignee         VARCHAR (100) NULL,
	severity         INT NULL,
	status           VARCHAR (20) NULL,
	attached_id      VARCHAR (20) NULL,
	remarks          VARCHAR (500) NULL,
	submission_date  DATE CONSTRAINT DF__comm_task__submi__55EAA1D1 DEFAULT (getdate()) NOT NULL,
	timestamp        DATETIME CONSTRAINT DF__comm_task__times__56DEC60A DEFAULT (getdate()) NOT NULL,
	CONSTRAINT PK__comm_tas__3213E83F448605B4 PRIMARY KEY (id),
	CONSTRAINT task_no UNIQUE (task_no)
	)
GO

IF OBJECT_ID ('dbo.comm_timesheet') IS NOT NULL
	DROP TABLE dbo.comm_timesheet
GO

CREATE TABLE dbo.comm_timesheet
	(
	id           INT IDENTITY NOT NULL,
	work_day     DATE NULL,
	user_name    VARCHAR (100) NULL,
	task_no      VARCHAR (50) NULL,
	task_type    VARCHAR (50) NULL,
	task_subject NVARCHAR (200) NULL,
	task_content TEXT NULL,
	effort       DECIMAL (12, 2) NULL,
	remarks      VARCHAR (500) NULL,
	timestamp    DATETIME CONSTRAINT DF__comm_time__times__7D8391DF DEFAULT (getdate()) NOT NULL,
	CONSTRAINT PK__comm_tim__3213E83F95582B34 PRIMARY KEY (id)
	)
GO

IF OBJECT_ID ('dbo.wf_def') IS NOT NULL
	DROP TABLE dbo.wf_def
GO

CREATE TABLE dbo.wf_def
	(
	wf_id      INT IDENTITY NOT NULL,
	wf_code    NVARCHAR (255) NOT NULL,
	wf_name    NVARCHAR (255) NOT NULL,
	state      NVARCHAR (20) NULL,
	wf_desc    NVARCHAR (500) NULL,
	created_by NVARCHAR (50) NULL,
	timestamp  DATETIME NOT NULL,
	PRIMARY KEY NONCLUSTERED (wf_code)
	)
GO

IF OBJECT_ID ('dbo.wf_flow_step_def') IS NOT NULL
	DROP TABLE dbo.wf_flow_step_def
GO

CREATE TABLE dbo.wf_flow_step_def
	(
	flow_step_id   INT IDENTITY NOT NULL,
	wf_code        NVARCHAR (255) NOT NULL,
	step_code      VARCHAR (255) NOT NULL,
	state          NVARCHAR (20) NOT NULL,
	assignee       NVARCHAR (100) NULL,
	assignee_group NVARCHAR (100) NULL,
	step_type      NVARCHAR (10) NOT NULL,
	step_repeat_no INT NULL,
	order_no       INT NOT NULL,
	from_step_code NVARCHAR (255) NULL,
	to_step_code   NVARCHAR (255) NULL,
	flow_step_desc NVARCHAR (500) NULL,
	is_multi       NVARCHAR (10) NULL,
	created_by     VARCHAR (50) NULL,
	timestamp      DATETIME CONSTRAINT DF__wf_flow_s__times__02E7657A DEFAULT (getdate()) NOT NULL,
	PRIMARY KEY NONCLUSTERED (wf_code, step_code)
	)
GO

IF OBJECT_ID ('dbo.wf_proc') IS NOT NULL
	DROP TABLE dbo.wf_proc
GO

CREATE TABLE dbo.wf_proc
	(
	proc_id        INT IDENTITY NOT NULL,
	wf_code        NVARCHAR (255) NOT NULL,
	step_code      VARCHAR (255) NOT NULL,
	business_id    VARCHAR (100) NULL,
	state          NVARCHAR (20) NOT NULL,
	assignee       NVARCHAR (100) NULL,
	assignee_group NVARCHAR (100) NULL,
	remark         NVARCHAR (500) NULL,
	owner_id       VARCHAR (100) NOT NULL,
	timestamp      DATETIME DEFAULT (getdate()) NOT NULL,
	PRIMARY KEY NONCLUSTERED (proc_id)
	)
GO

IF OBJECT_ID ('dbo.wf_proc_his') IS NOT NULL
	DROP TABLE dbo.wf_proc_his
GO

CREATE TABLE dbo.wf_proc_his
	(
	proc_his_id  INT IDENTITY NOT NULL,
	wf_code      NVARCHAR (255) NOT NULL,
	step_code    VARCHAR (255) NOT NULL,
	business_id  VARCHAR (100) NULL,
	owner_id     VARCHAR (100) NOT NULL,
	assignee     VARCHAR (100) NOT NULL,
	state        NVARCHAR (20) NOT NULL,
	approve_code NVARCHAR (20) NULL,
	remark       NVARCHAR (500) NULL,
	timestamp    DATETIME DEFAULT (getdate()) NOT NULL,
	PRIMARY KEY NONCLUSTERED (proc_his_id)
	)
GO

IF OBJECT_ID ('dbo.wf_step_def') IS NOT NULL
	DROP TABLE dbo.wf_step_def
GO

CREATE TABLE dbo.wf_step_def
	(
	step_id    INT IDENTITY NOT NULL,
	step_code  NVARCHAR (255) NOT NULL,
	step_name  VARCHAR (255) NOT NULL,
	state      NVARCHAR (20) NULL,
	step_desc  NVARCHAR (500) NULL,
	created_by VARCHAR (50) NULL,
	timestamp  DATETIME CONSTRAINT DF__wf_step_d__times__7D2E8C24 DEFAULT (getdate()) NOT NULL,
	PRIMARY KEY NONCLUSTERED (step_code)
	)
GO

