/* 1) Вывести все уникальные имена ролей пользователей.*/
SELECT DISTINCT role_name FROM m_roles;

/* 2) Подсчитать число машин у каждого пользователя.
Вывести в формате
User full name (username + пробел + user surname) | Число машин у пользователя.*/

SELECT   m_users.username || ' '||
                                      m_users.surname as "Full name",
                                      count (model) as "number of cars"
                              from m_users
                                       join m_cars mc on m_users.id = mc.user_id

                              group by m_users.username,m_users.surname;

/* 3) Подсчитать для каждого диллера число машин, старше 2018 года производства с красным кузовом.*/

SELECT name as Dealer_name, count(model) FROM m_auto_dealer as d
    JOIN m_cars mc on d.id = mc.dealer_id
    JOIN m_body mb on mc.id = mb.car_id
WHERE  mb.created >date'20181231' AND color='RED'
GROUP BY name;

/* 4) Найти пользователей не из Беларуси и России,
у которых есть машина 2010-2015 года выпуска из Германии
и купленную в диллере не в Германии с объемом двигателя больше 3 литра.*/

SELECT username FROM m_users
    JOIN m_cars mc on m_users.id = mc.user_id
    JOIN m_body mb on mc.id = mb.car_id
    JOIN m_engine me on mc.id = me.car_id
    JOIN m_auto_dealer mad on mc.dealer_id = mad.id
WHERE mb.created BETWEEN date('20100101') AND date('20150101') AND manufacture = 'Germany'
  AND NOT country='Germany' AND volume>3;

/* 5)Определить логины пользователей, имеющих больше 3 машин.*/

SELECT login FROM
                  (SELECT login, count(model) as count FROM m_users JOIN m_cars m on m_users.id = m.user_id GROUP BY login) as T
WHERE count>3;


/* 6) Вывести уникальных диллеров с подсчитанной суммой стоимостей машин, связанных с ними.*/

SELECT DISTINCT name, sum (price) FROM m_auto_dealer JOIN m_cars mc on m_auto_dealer.id = mc.dealer_id
GROUP BY name;

/* 7) Подсчитать количество уникальных пользователей,
владеющих хотя бы одной машиной, стоимость которой превышает среднюю стоимость всех машин.*/

SELECT count(DISTINCT login) FROM m_users JOIN m_cars mc on m_users.id = mc.user_id
WHERE price>(SELECT AVG(price) FROM m_cars)