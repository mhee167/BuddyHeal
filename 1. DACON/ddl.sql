

CREATE TABLE USER_INFO(
    user_email  VARCHAR(100) PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL
);
CREATE TABLE chat_logs (
    conversation_id INT PRIMARY KEY,
    user_id VARCHAR(100),
    question VARCHAR2(4000) NOT NULL, 
    response VARCHAR2(4000) NOT NULL,
    question_Timestamp TIMESTAMP NOT NULL,
    response_Timestamp TIMESTAMP NOT NULL,
    FOREIGN KEY (USER_ID) REFERENCES user_info(user_email)
);

CREATE SEQUENCE conversation_id_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;



CREATE OR REPLACE TRIGGER conversation_log_trigger
BEFORE INSERT ON chat_logs
FOR EACH ROW
BEGIN
    SELECT conversation_id_seq.NEXTVAL INTO :NEW.conversation_id FROM dual;
END;


