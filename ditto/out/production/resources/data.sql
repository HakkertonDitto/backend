-- < category_entity > --
insert into category_entity (category_id, category)
values (1, '카테고리1'),
       (2, '카테고리2'),
       (3, '카테고리3');

-- < helper_entity > --
insert into helper_entity (helper_id, nickname, phone_number, grade, category_id, time, point, help_on_off, help_count)
values (1, '김가희', '010-0000-0001', 1, 1, 1, 1, true, 1);



insert into comment_entity (comment_id, helper_id, comment)
values (1, 1, '짱1'),
       (2, 1, '짱1'),
       (3, 1, '짱3');