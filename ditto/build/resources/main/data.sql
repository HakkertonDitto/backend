-- < helper > --
insert into helper (helper_id, nickname, phone_number, time, point, help_on_off)
values (1, '김가희', '010-0000-0001', 1, 1, true),
       (2, '김나희', '010-0000-0002', 2, 2, false),
       (3, '김다희', '010-0000-0003', 3, 3, true);

-- << help_type >> --
insert into help_type(help_type_id, category, detail)
values (1, 'RESTAURANT_CAFE', '디테일1'),
       (2, 'HOSPITAL', '디테일2'),
       (3, 'BANK_PUBLIC_OFFICE', '디테일3'),
       (4, 'TICKET', '디테일4'),
       (5, 'RESTAURANT_CAFE', '디테일5'),
       (6, 'HOSPITAL', '디테일6');

-- << help_seeker >> --
insert into help_seeker(help_seeker_id, help_type_id)
values (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (6, 6);


-- << donor >> --
insert into donor(id, helper_id, call_time, score, comment)
values (1, 1, 10, 1, '짱1'),
       (2, 2, 20, 2, '짱2'),
       (3, 2, 30, 3, '짱3'),
       (4, 3, 40, 4, '짱4'),
       (5, 3, 50, 5, '짱5'),
       (6, 3, 60, 6, '짱6');
