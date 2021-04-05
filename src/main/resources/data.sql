DROP TABLE c4d_physical_activity_stats^;

CREATE VIEW c4d_physical_activity_stats AS
	SELECT DATE(time) AS date, SUM(duration) AS duration, ROUND(SUM(duration*energy_per_hour/3600.0)) as energy FROM "c4d_entry" E
	    JOIN "c4d_entry_type" ET ON (E.type=ET.id)
	    WHERE entry_type_class='PHYSICAL_ACTIVITY'
	    GROUP BY DATE(time)
	    ORDER BY date DESC^;

INSERT INTO c4d_role (id) VALUES ('ADMIN')^;
INSERT INTO c4d_role (id) VALUES ('USER')^;

INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('NOTE', 'n', 'NOTE', 'Note', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('RESOURCE', 'n', 'RESOURCE', 'Ressource', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('WALKING_SLOW', 'n', 'PHYSICAL_ACTIVITY', 'Marche lente', 210)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('WALKING_NORMAL', 'n', 'PHYSICAL_ACTIVITY', 'Marche', 300)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('WALKING_FAST', 'n', 'PHYSICAL_ACTIVITY', 'Marche rapide', 420)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('RUNNING', 'n', 'PHYSICAL_ACTIVITY', 'Course', 600)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('STEPPING', 'n', 'PHYSICAL_ACTIVITY', 'Stepping', 600)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('BIKING_10', 'n', 'PHYSICAL_ACTIVITY', 'Vélo 10km/h', 210)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('BIKING_15', 'n', 'PHYSICAL_ACTIVITY', 'Vélo 15km/h', 420)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('BIKING_20', 'n', 'PHYSICAL_ACTIVITY', 'Vélo 20km/h', 600)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('MATHEMATICS', 'n', 'INTELLECTUAL_ACTIVITY', 'Mathématiques', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('CHINESE', 'n', 'INTELLECTUAL_ACTIVITY', 'Chinois', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('HEALTH', 'n', 'INTELLECTUAL_ACTIVITY', 'Santé', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('ENGLISH', 'n', 'INTELLECTUAL_ACTIVITY', 'Anglais', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('ANXIETY', 'n', 'SYMPTOM', 'Anxiété', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('COUGH', 'n', 'SYMPTOM', 'Toux', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('DIARRHEA', 'n', 'SYMPTOM', 'Diarrhé', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('DISCOURAGEMENT', 'n', 'SYMPTOM', 'Découragement', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('FATIGUE', 'n', 'SYMPTOM', 'Fatigue', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('HEADACHE', 'n', 'SYMPTOM', 'Mal de tête', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('INSOMNIA', 'n', 'SYMPTOM', 'Insomnie', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('NIGHT_SWEATS', 'n', 'SYMPTOM', 'Sueurs nocturnes', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('NAUSEA', 'n', 'SYMPTOM', 'Nausée', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('RHINITIS', 'n', 'SYMPTOM', 'Rhinite', NULL)^;
INSERT INTO c4d_entry_type (id, calendar_user, entry_type_class, name, energy_per_hour) VALUES ('BACK_PAIN', 'n', 'SYMPTOM', 'Mal au dos', NULL)^;

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
INSERT INTO c4d_user_role (id, user_id, role) VALUES ('n-USER', 'n', 'USER')^;
INSERT INTO c4d_user_role (id, user_id, role) VALUES ('a-USER', 'a', 'USER')^;
INSERT INTO c4d_user_role (id, user_id, role) VALUES ('d-USER', 'd', 'USER')^;

INSERT INTO c4d_topic (id, calendar_user, name) VALUES ('NICOLAS_HEALTH', 'n', 'My health')^;
INSERT INTO c4d_topic (id, calendar_user, name) VALUES ('NICOLAS_CLIENTS', 'n', 'Work time by client')^;
INSERT INTO c4d_topic (id, calendar_user, name) VALUES ('ANNE_CLIENTS', 'a', 'Work time by client')^;

INSERT INTO c4d_calendar_user (user_name, password) VALUES ('n', '$2y$12$K3tLc8T8t1v5T4Jusij76.iVp92vT2owjef4komhSfioiw7iYI8ei')^;
INSERT INTO c4d_calendar_user (user_name, password) VALUES ('a', '$2y$12$K3tLc8T8t1v5T4Jusij76.iVp92vT2owjef4komhSfioiw7iYI8ei')^;
INSERT INTO c4d_calendar_user (user_name, password) VALUES ('d', '$2y$12$K3tLc8T8t1v5T4Jusij76.iVp92vT2owjef4komhSfioiw7iYI8ei')^;
