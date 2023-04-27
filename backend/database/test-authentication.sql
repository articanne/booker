INSERT INTO public.roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO public.roles (id, name) VALUES (2, 'USER');
INSERT INTO public.roles (id, name) VALUES (3, 'OTHER');


INSERT INTO public.users (id, password, username) VALUES (1, '$2a$10$/eCF9suWC3xsQP1bPIxziewkIZZYuEQTSmjotc68jBrzlKAnMOlDa', 'USER1');
INSERT INTO public.users (id, password, username) VALUES (2, '$2a$10$ZbRTWIEOG1vn7n5C3frLjupr73jLZWKsWizZIKSLI4psjNoyEzIze', 'USER2');
INSERT INTO public.users (id, password, username) VALUES (3, '$2a$10$e.TBywAAsOh6vhAtzo8kC.BQMErmhEAhT7OLGRrFcLJ5voj9Ce/Sa', 'USER3');
INSERT INTO public.users (id, password, username) VALUES (4, '$2a$10$MEzNtmrdH4I1ba6YTOU17etr.tq3qX3WenFGLLBrVbSahCIC4jlpe', 'USER4');
INSERT INTO public.users (id, password, username) VALUES (5, '$2a$10$vie4F6xPYpAE9TNgbJFNZOvs1gAJQJkwXqszOLc0KYdBKt2qTLEpi', 'USER5');
INSERT INTO public.users (id, password, username) VALUES (6, '$2a$10$2Nd8UkMrNa9mnqccnfKN0Oim1bAELPST77/TFJPTPgP8j4qKEszDu', 'USER6');

INSERT INTO public.user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO public.user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO public.user_roles (user_id, role_id) VALUES (3, 3);
INSERT INTO public.user_roles (user_id, role_id) VALUES (4, 3);
INSERT INTO public.user_roles (user_id, role_id) VALUES (4, 1);
INSERT INTO public.user_roles (user_id, role_id) VALUES (5, 3);
INSERT INTO public.user_roles (user_id, role_id) VALUES (5, 2);
INSERT INTO public.user_roles (user_id, role_id) VALUES (6, 1);
INSERT INTO public.user_roles (user_id, role_id) VALUES (6, 2);
