-- < helper_entity > --
insert into helper_entity (helper_id, nickname, phone_number, time, point, help_on_off, help_count)
values (1, '김가희', '010-0000-0001', 1, 1, true, 1),
       (2, '김나희', '010-0000-0002', 2, 2, false, 2),
       (3, '김다희', '010-0000-0003', 3, 3, true, 3);


-- < comment_entity > --
insert into comment_entity (comment_id, helper_id, comment)
values (1, 1, '짱1'),
       (2, 2, '짱1'),
       (3, 2, '짱3'),
       (4, 3, '짱3'),
       (5, 3, '짱3'),
       (6, 3, '짱3');

-- << help_type_entity >> --
insert into help_type_entity(help_type_id, category, detail)
values (1, '카테고리1', '디테일1'),
       (2, '카테고리2', '디테일2'),
       (3, '카테고리3', '디테일3'),
       (4, '카테고리4', '디테일4'),
       (5, '카테고리5', '디테일5'),
       (6, '카테고리6', '디테일6');

-- << help_seeker_entity >> --
insert into help_seeker_entity(help_seeker_id, help_type_id)
values (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (6, 6);


-- << donor >> --
insert into donor(id, helper_entity_helper_id, call_time, score, comment)
values (1, 1, 10, 1, '짱1'),
       (2, 2, 20, 2, '짱2'),
       (3, 2, 30, 3, '짱3'),
       (4, 3, 40, 4, '짱4'),
       (5, 3, 50, 5, '짱5'),
       (6, 3, 60, 6, '짱6');

-- << helper_entity_scores >> --
insert into helper_entity_scores(helper_entity_helper_id, scores)
values (1, 1),
       (2, 2),
       (2, 3),
       (3, 4),
       (3, 5),
       (3, 6);