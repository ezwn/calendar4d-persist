DROP TABLE c4d_physical_activity_stats^;

CREATE VIEW c4d_physical_activity_stats AS
	SELECT DATE(time) AS date, SUM(duration) AS duration, ROUND(SUM(duration*energy/3600.0)) as energy FROM "c4d_entry" E
	    JOIN "c4d_entry_type" ET ON (E.type=ET.id)
	    JOIN "c4d_physical_activity" PA ON (ET.physical_activity=PA.id)
	    WHERE entry_type_class='PHYSICAL_ACTIVITY'
	    GROUP BY DATE(time)
	    ORDER BY date DESC^;

INSERT INTO c4d_role (id) VALUES ('ADMIN')^;
INSERT INTO c4d_role (id) VALUES ('USER')^;

INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('NOTE', 'n', 'NOTE', 'Note', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('RESOURCE', 'nicolas', 'RESOURCE', 'Ressource', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('WALKING_SLOW', 'nicolas', 'PHYSICAL_ACTIVITY', 'Marche lente', 'WALKING_SLOW')^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('WALKING_NORMAL', 'nicolas', 'PHYSICAL_ACTIVITY', 'Marche', 'WALKING_NORMAL')^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('WALKING_FAST', 'nicolas', 'PHYSICAL_ACTIVITY', 'Marche rapide', 'WALKING_FAST')^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('RUNNING', 'nicolas', 'PHYSICAL_ACTIVITY', 'Course', 'RUNNING')^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('STEPPING', 'nicolas', 'PHYSICAL_ACTIVITY', 'Stepping', 'STEPPING')^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('BIKING_10', 'nicolas', 'PHYSICAL_ACTIVITY', 'Vélo 10km/h', 'BIKING_10')^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('BIKING_15', 'nicolas', 'PHYSICAL_ACTIVITY', 'Vélo 15km/h', 'BIKING_15')^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('BIKING_20', 'nicolas', 'PHYSICAL_ACTIVITY', 'Vélo 20km/h', 'BIKING_20')^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('MATHEMATICS', 'nicolas', 'INTELLECTUAL_ACTIVITY', 'Mathématiques', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('CHINESE', 'nicolas', 'INTELLECTUAL_ACTIVITY', 'Chinois', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('HEALTH', 'nicolas', 'INTELLECTUAL_ACTIVITY', 'Santé', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('ENGLISH', 'nicolas', 'INTELLECTUAL_ACTIVITY', 'Anglais', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('ANXIETY', 'nicolas', 'SYMPTOM', 'Anxiété', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('COUGH', 'nicolas', 'SYMPTOM', 'Toux', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('DIARRHEA', 'nicolas', 'SYMPTOM', 'Diarrhé', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('DISCOURAGEMENT', 'nicolas', 'SYMPTOM', 'Découragement', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('FATIGUE', 'nicolas', 'SYMPTOM', 'Fatigue', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('HEADACHE', 'nicolas', 'SYMPTOM', 'Mal de tête', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('INSOMNIA', 'nicolas', 'SYMPTOM', 'Insomnie', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('NIGHT_SWEATS', 'nicolas', 'SYMPTOM', 'Sueurs nocturnes', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('NAUSEA', 'nicolas', 'SYMPTOM', 'Nausée', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('RHINITIS', 'nicolas', 'SYMPTOM', 'Rhinite', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, physical_activity) VALUES ('BACK_PAIN', 'nicolas', 'SYMPTOM', 'Mal au dos', NULL)^;

INSERT INTO c4d_attribute_requirement (id, meaning) VALUES ('DISABLED', 'Attribute can''t be used')^;
INSERT INTO c4d_attribute_requirement (id, meaning) VALUES ('ENABLED', 'Attribute can be used')^;
INSERT INTO c4d_attribute_requirement (id, meaning) VALUES ('REQUIRED', 'Attribute is required')^;

INSERT INTO c4d_entry_type_class (id, name, duration, position) VALUES ('NOTE', 'Note', 'ENABLED', 'ENABLED')^;
INSERT INTO c4d_entry_type_class (id, name, duration, position) VALUES ('PHYSICAL_ACTIVITY', 'Physical activity', 'REQUIRED', 'ENABLED')^;
INSERT INTO c4d_entry_type_class (id, name, duration, position) VALUES ('WORK', 'Work', 'REQUIRED', 'ENABLED')^;
INSERT INTO c4d_entry_type_class (id, name, duration, position) VALUES ('INTELLECTUAL_ACTIVITY', 'Intellectual activity', 'REQUIRED', 'ENABLED')^;
INSERT INTO c4d_entry_type_class (id, name, duration, position) VALUES ('SYMPTOM', 'Symptom', 'ENABLED', 'DISABLED')^;
INSERT INTO c4d_entry_type_class (id, name, duration, position) VALUES ('RESOURCE', 'Resource', 'DISABLED', 'REQUIRED')^;

INSERT INTO c4d_user_role (id, user_id, role) VALUES ('n-ADMIN', 'n', 'ADMIN')^;
INSERT INTO c4d_user_role (id, user_id, role) VALUES ('a-USER', 'a', 'USER')^;
INSERT INTO c4d_user_role (id, user_id, role) VALUES ('d-USER', 'd', 'USER')^;

INSERT INTO c4d_physical_activity (id, energy) VALUES ('WALKING_SLOW', 210)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('WALKING_NORMAL', 300)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('WALKING_FAST', 420)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('RUNNING', 600)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('STEPPING', 600)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('BIKING_10', 210)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('BIKING_15', 420)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('BIKING_20', 600)^;

INSERT INTO c4d_topic (id, calendar_user, name) VALUES ('NICOLAS_HEALTH', 'nicolas', 'My health')^;
INSERT INTO c4d_topic (id, calendar_user, name) VALUES ('NICOLAS_CLIENTS', 'nicolas', 'Work time by client')^;
INSERT INTO c4d_topic (id, calendar_user, name) VALUES ('ANNE_CLIENTS', 'anne', 'Work time by client')^;
INSERT INTO c4d_topic (id, calendar_user, name) VALUES ('repo<Topic>', 'for', 'Admin')^;

INSERT INTO c4d_calendar_user (user_name, password) VALUES ('n', '$2y$12$K3tLc8T8t1v5T4Jusij76.iVp92vT2owjef4komhSfioiw7iYI8ei')^;
INSERT INTO c4d_calendar_user (user_name, password) VALUES ('a', '$2y$12$K3tLc8T8t1v5T4Jusij76.iVp92vT2owjef4komhSfioiw7iYI8ei')^;
INSERT INTO c4d_calendar_user (user_name, password) VALUES ('d', '$2y$12$K3tLc8T8t1v5T4Jusij76.iVp92vT2owjef4komhSfioiw7iYI8ei')^;
