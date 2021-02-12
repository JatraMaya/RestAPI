
    create table public.cities (
       id uuid not null,
        city_name varchar(255) not null,
        primary key (id)
    )

    create table public.users (
       id uuid not null,
        alias varchar(255),
        email varchar(255),
        name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        role varchar default 'VOLUNTEER',
        status varchar default 'ACTIVE',
        city_id uuid,
        primary key (id)
    )

    alter table public.cities 
       add constraint UK_rlmpoah07xxtfr03pmosd593p unique (city_name)

    alter table public.users 
       add constraint FKn36jwt4acj3il2ixvv2c0ncco 
       foreign key (city_id) 
       references public.cities

    create table public.cities (
       id uuid not null,
        city_name varchar(255) not null,
        primary key (id)
    )

    create table public.users (
       id uuid not null,
        alias varchar(255),
        email varchar(255),
        name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        role varchar default 'VOLUNTEER',
        status varchar default 'ACTIVE',
        city_id uuid,
        primary key (id)
    )

    alter table public.cities 
       add constraint UK_rlmpoah07xxtfr03pmosd593p unique (city_name)

    alter table public.users 
       add constraint FKn36jwt4acj3il2ixvv2c0ncco 
       foreign key (city_id) 
       references public.cities

    create table public.cities (
       id uuid not null,
        city_name varchar(255) not null,
        primary key (id)
    )

    create table public.users (
       id uuid not null,
        alias varchar(255),
        email varchar(255),
        name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        role varchar default 'VOLUNTEER',
        status varchar default 'ACTIVE',
        city_id uuid,
        primary key (id)
    )

    alter table public.cities 
       add constraint UK_rlmpoah07xxtfr03pmosd593p unique (city_name)

    alter table public.users 
       add constraint FKn36jwt4acj3il2ixvv2c0ncco 
       foreign key (city_id) 
       references public.cities
