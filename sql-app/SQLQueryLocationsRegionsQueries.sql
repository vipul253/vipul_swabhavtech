--region wise countries
select region_name,country_name
from regions
left join countries
on countries.region_id=regions.region_id

--country wise locations
select country_name,locations.*
from countries
join locations
on countries.country_id=locations.country_id

--region with no country
select region_name,country_name
from regions
left join countries
on countries.region_id=regions.region_id
where country_id is null

--country with no location
select country_name,locations.*
from countries
left join locations
on countries.country_id=locations.country_id
where location_id is null

--country name region name
select c.country_name,r.region_name
from countries c
join regions r
on c.region_id=r.region_id

--country name and region name and location name
select c.country_name,r.region_name,l.city
from countries c
join regions r
on c.region_id=r.region_id
join locations l
on l.country_id=c.country_id

--insert swabhavtech, display fulladdress of swabhav 
select l.street_address,l.city,l.postal_code,l.state_province,c.country_name,r.region_name
from locations l
join countries c
on l.country_id=c.country_id
join regions r
on c.region_id=r.region_id
where l.location_id=2000