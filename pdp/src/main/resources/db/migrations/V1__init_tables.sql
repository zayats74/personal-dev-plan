CREATE SCHEMA IF NOT EXISTS personal_dev_plan;

CREATE TABLE IF NOT EXISTS personal_dev_plan.user_types (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  displayed BOOLEAN NOT NULL DEFAULT TRUE,
  ordinal INT NOT NULL DEFAULT 1000
);

CREATE TABLE IF NOT EXISTS personal_dev_plan.sections (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  displayed BOOLEAN NOT NULL DEFAULT TRUE,
  ordinal INT NOT NULL DEFAULT 1000
);

CREATE TABLE IF NOT EXISTS personal_dev_plan.goals (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  displayed BOOLEAN NOT NULL DEFAULT TRUE,
  ordinal INT NOT NULL DEFAULT 1000
);

CREATE TYPE personal_dev_plan.StatusEnum AS ENUM ('InProgress', 'Planned', 'KnowledgeBase');

CREATE TABLE IF NOT EXISTS personal_dev_plan.books (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  status personal_dev_plan.StatusEnum NOT NULL,
  section_id INT NOT NULL,
  goal_id INT NOT NULL,
  ordinal INT NOT NULL,
  start_date DATE,
  end_date DATE,
  information TEXT,
  plan VARCHAR[],
  authors VARCHAR(255) NOT NULL,
  pages INT NOT NULL
);