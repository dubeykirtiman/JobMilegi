-- Create the job table if it does not exist
CREATE TABLE IF NOT EXISTS job (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    company_name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    salary DOUBLE PRECISION NOT NULL,
    posted_at TIMESTAMP NOT NULL DEFAULT NOW()
);

-- If the table exists, alter it to add any missing fields
ALTER TABLE job
ADD COLUMN IF NOT EXISTS title VARCHAR(255) NOT NULL,
ADD COLUMN IF NOT EXISTS description TEXT NOT NULL,
ADD COLUMN IF NOT EXISTS company_name VARCHAR(255) NOT NULL,
ADD COLUMN IF NOT EXISTS location VARCHAR(255) NOT NULL,
ADD COLUMN IF NOT EXISTS salary DOUBLE PRECISION NOT NULL,
ADD COLUMN IF NOT EXISTS posted_at TIMESTAMP NOT NULL DEFAULT NOW();
