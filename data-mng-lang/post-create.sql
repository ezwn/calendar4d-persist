DROP TABLE c4d_physical_activity_stats^;

CREATE VIEW c4d_physical_activity_stats AS
	SELECT DATE(time) AS date, SUM(duration) AS duration, ROUND(SUM(duration*energy/3600.0)) as energy FROM "c4d_entry" E
	    JOIN "c4d_entry_type" ET ON (E.type=ET.id)
	    JOIN "c4d_physical_activity" PA ON (ET.physical_activity=PA.id)
	    WHERE category='PHYSICAL_ACTIVITY'
	    GROUP BY DATE(time)
	    ORDER BY date DESC^;