DROP TABLE c4d_physical_activity_stats^;

CREATE VIEW c4d_physical_activity_stats AS
	SELECT DATE(time) AS date, SUM(duration) AS duration, ROUND(SUM(duration*energy/3600.0)) as energy FROM "c4d_entry" E
	    JOIN "c4d_entry_type" ET ON (E.type=ET.id)
	    JOIN "c4d_physical_activity" PA ON (ET.physical_activity=PA.id)
	    WHERE category='PHYSICAL_ACTIVITY'
	    GROUP BY DATE(time)
	    ORDER BY date DESC^;

INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('NOTE', 'NOTE', 'Note', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('RESOURCE', 'RESOURCE', 'Ressource', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('WALKING_SLOW', 'PHYSICAL_ACTIVITY', 'Marche lente', 'WALKING_SLOW')^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('WALKING_NORMAL', 'PHYSICAL_ACTIVITY', 'Marche', 'WALKING_NORMAL')^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('WALKING_FAST', 'PHYSICAL_ACTIVITY', 'Marche rapide', 'WALKING_FAST')^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('RUNNING', 'PHYSICAL_ACTIVITY', 'Course', 'RUNNING')^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('STEPPING', 'PHYSICAL_ACTIVITY', 'Stepping', 'STEPPING')^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('BIKING_10', 'PHYSICAL_ACTIVITY', 'Vélo 10km/h', 'BIKING_10')^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('BIKING_15', 'PHYSICAL_ACTIVITY', 'Vélo 15km/h', 'BIKING_15')^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('BIKING_20', 'PHYSICAL_ACTIVITY', 'Vélo 20km/h', 'BIKING_20')^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('MATHEMATICS', 'INTELLECTUAL_ACTIVITY', 'Mathématiques', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('CHINESE', 'INTELLECTUAL_ACTIVITY', 'Chinois', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('HEALTH', 'INTELLECTUAL_ACTIVITY', 'Santé', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('ENGLISH', 'INTELLECTUAL_ACTIVITY', 'Anglais', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('ANXIETY', 'SYMPTOM', 'Anxiété', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('COUGH', 'SYMPTOM', 'Toux', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('DIARRHEA', 'SYMPTOM', 'Diarrhé', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('DISCOURAGEMENT', 'SYMPTOM', 'Découragement', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('FATIGUE', 'SYMPTOM', 'Fatigue', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('HEADACHE', 'SYMPTOM', 'Mal de tête', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('INSOMNIA', 'SYMPTOM', 'Insomnie', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('NIGHT_SWEATS', 'SYMPTOM', 'Sueurs nocturnes', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('NAUSEA', 'SYMPTOM', 'Nausée', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('RHINITIS', 'SYMPTOM', 'Rhinite', NULL)^;
INSERT INTO c4d_entry_type (id, category, name, physical_activity) VALUES ('BACK_PAIN', 'SYMPTOM', 'Mal au dos', NULL)^;

INSERT INTO c4d_attribute_requirement (id, meaning) VALUES ('DISABLED', 'Attribute can''t be used')^;
INSERT INTO c4d_attribute_requirement (id, meaning) VALUES ('ENABLED', 'Attribute can be used')^;
INSERT INTO c4d_attribute_requirement (id, meaning) VALUES ('REQUIRED', 'Attribute is required')^;

INSERT INTO c4d_physical_activity (id, energy) VALUES ('WALKING_SLOW', 210)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('WALKING_NORMAL', 300)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('WALKING_FAST', 420)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('RUNNING', 600)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('STEPPING', 600)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('BIKING_10', 210)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('BIKING_15', 420)^;
INSERT INTO c4d_physical_activity (id, energy) VALUES ('BIKING_20', 600)^;

INSERT INTO c4d_subject (id, name) VALUES ('ME', 'Moi')^;

INSERT INTO c4d_calendar_user (user_name, password) VALUES ('nicolas', 'a1*a1*a1*')^;
INSERT INTO c4d_calendar_user (user_name, password) VALUES ('anne', 'a1*a1*a1*')^;

INSERT INTO c4d_entry_type_category (id, name, duration, position) VALUES ('NOTE', 'Note', 'ENABLED', 'ENABLED')^;
INSERT INTO c4d_entry_type_category (id, name, duration, position) VALUES ('PHYSICAL_ACTIVITY', 'Activité physique', 'REQUIRED', 'ENABLED')^;
INSERT INTO c4d_entry_type_category (id, name, duration, position) VALUES ('INTELLECTUAL_ACTIVITY', 'Activité intellectuelle', 'REQUIRED', 'ENABLED')^;
INSERT INTO c4d_entry_type_category (id, name, duration, position) VALUES ('SYMPTOM', 'Symptôme', 'ENABLED', 'DISABLED')^;
INSERT INTO c4d_entry_type_category (id, name, duration, position) VALUES ('RESOURCE', 'Resource', 'DISABLED', 'REQUIRED')^;
