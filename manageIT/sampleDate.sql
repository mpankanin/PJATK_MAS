INSERT INTO CUSTOMER (first_name, last_name, birth_date, email, phone_number, correspondence_address, is_army_member, is_pregnant, maiden_name, company)
VALUES
    ('John', 'Doe', '1980-01-01', 'john.doe@example.com', '1234567890', '123 Main St, New York, NY 10001', true, null, null, 'Doe Inc'),
    ('Mary', 'Campo', '1985-02-02', 'mary.campo@example.com', '0987654321', '456 Maple Ave, Los Angeles, CA 90001', null, false, 'Johnson', 'Compo Corp'),
    ('Jim', 'Kerry', '1990-03-03', 'jim.kerry@example.com', '1122334455', '789 Oak Dr, Chicago, IL 60601', false, null, null, 'Kerry LLC');

INSERT INTO ORDERS (insertion_date, payment_status, price, person_id)
VALUES
    ('2022-01-15', 1, 10000.00, 1),
    ('2023-02-02', 2, 20000.00, 2),
    ('2024-05-19', 1, 30000.00, 3);

INSERT INTO PROJECT_TEAM (name)
VALUES
    ('Team 1'),
    ('Team 2'),
    ('Team 3');

INSERT INTO TEAM_MEMBER (birth_date, correspondence_address, email, first_name, is_army_member, is_pregnant, last_name, maiden_name, phone_number, bonus, hire_date, release_date, salary, mba_aqusition_date, role, project_team_id)
VALUES
    ('1980-01-01', '123 Main St, New York, NY 10001', 'adam.kurpiensky@manageit.com', 'Adam', true, null, 'Kurpiensky', null, '1234567890', 1000.00, '2022-01-15', null, 5000.00, '2022-01-15', 2, 1);

INSERT INTO PROJECT (DESCRIPTION, START_DATE, NAME, FINISH_DATE, ORDER_ID, PROJECT_TEAM_ID)
VALUES
    ('Project 1', '2022-01-20', 'Project 1', '2021-01-01', 1, 1),
    ('Project 2', '2023-02-20', 'Project 2', '2022-02-02', 2, 2),
    ('Project 3', '2024-05-25', 'Project 3', '2023-03-03', 3, 3);