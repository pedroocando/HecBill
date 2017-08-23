# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cities (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  id_country                    integer not null,
  name_city                     varchar(255) not null,
  constraint uq_cities_name_city unique (name_city),
  constraint pk_cities primary key (id)
);

create table configs (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  key_config                    varchar(255) not null,
  value_config                  varchar(255) not null,
  constraint uq_configs_key_config unique (key_config),
  constraint pk_configs primary key (id)
);

create table countries (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  name_country                  varchar(255) not null,
  constraint uq_countries_name_country unique (name_country),
  constraint pk_countries primary key (id)
);

create table creditcard_tokens (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  id_customer                   integer not null,
  token_credit_card_token       varchar(255) not null,
  date_created_credit_cardtoken datetime(6) not null,
  constraint uq_creditcard_tokens_token_credit_card_token unique (token_credit_card_token),
  constraint pk_creditcard_tokens primary key (id)
);

create table customers (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  id_partner                    integer not null,
  identifier_customer           varchar(255) not null,
  name_customer                 varchar(255) not null,
  last_name_customer            varchar(255) not null,
  phone_number_customer         varchar(255) not null,
  adress_customer               varchar(255) not null,
  date_admission_customer       datetime(6) not null,
  date_experiation_customer     datetime(6) not null,
  birth_date_customer           datetime(6) not null,
  date_updated_customer         datetime(6) not null,
  notify_customer               tinyint(1) default 0 not null,
  status_customer               integer not null,
  num_contrac_customer          varchar(255) not null,
  balance_customer              double not null,
  id_current_invoice            integer not null,
  last_ok_billing_date          datetime(6) not null,
  email_customer                varchar(255) not null,
  constraint uq_customers_identifier_customer unique (identifier_customer),
  constraint uq_customers_phone_number_customer unique (phone_number_customer),
  constraint uq_customers_num_contrac_customer unique (num_contrac_customer),
  constraint uq_customers_email_customer unique (email_customer),
  constraint pk_customers primary key (id)
);

create table customer_has_extradata (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  name_extra_data               varchar(255) not null,
  constraint pk_customer_has_extradata primary key (id)
);

create table customer_has_plans (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  id_plan                       integer not null,
  id_customer                   integer not null,
  startdate_customer_plan       datetime(6) not null,
  end_date_customer_plan        datetime(6) not null,
  status_customer_plan          integer not null,
  constraint pk_customer_has_plans primary key (id)
);

create table frecuencies (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  id_partner                    integer not null,
  day_frecuency                 varchar(255) not null,
  month_frecuency               varchar(255) not null,
  day_of_week_frecuency         varchar(255) not null,
  name_frecuency                varchar(255) not null,
  constraint pk_frecuencies primary key (id)
);

create table invoices (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  id_customer                   integer not null,
  id_plan                       integer,
  total_invoice                 double not null,
  payment_attempts_invoice      integer not null,
  status_invoice                integer not null,
  balance_invoice               double not null,
  date_created_invoice          datetime(6) not null,
  last_updated_invoice          datetime(6) not null,
  fee_rate_partner              double,
  taxt_rate_invoice             double,
  constraint pk_invoices primary key (id)
);

create table invoice_lines (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  description_item_type         varchar(255) not null,
  constraint pk_invoice_lines primary key (id)
);

create table partners (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  id_parent_partner             integer,
  name_partner                  varchar(255) not null,
  adress_partner                varchar(255) not null,
  phone_partner                 varchar(255) not null,
  status_partner                integer not null,
  id_city                       integer not null,
  fee_rate_partner              double not null,
  id_num_priority_partner       integer not null,
  email_partner                 varchar(255) not null,
  token                         TEXT,
  constraint uq_partners_name_partner unique (name_partner),
  constraint uq_partners_phone_partner unique (phone_partner),
  constraint uq_partners_email_partner unique (email_partner),
  constraint pk_partners primary key (id)
);

create table payments (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  id_invoice                    integer not null,
  id_token                      integer not null,
  amount_payment                double not null,
  date_created_payment          datetime(6) not null,
  type_payment                  varchar(255) not null,
  result_status_payment         varchar(255),
  descriptioon_payment          varchar(255),
  constraint uq_payments_id_token unique (id_token),
  constraint pk_payments primary key (id)
);

create table plans (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  id_partner                    integer not null,
  id_plan_partner               varchar(255) not null,
  name_plan                     varchar(255) not null,
  fee_cost_plan                 double not null,
  enrollment_cost_plan          double not null,
  id_frecuency                  integer not null,
  status_plan                   integer not null,
  tax_rate_plan                 double not null,
  constraint pk_plans primary key (id)
);

create table roles (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  name_role                     varchar(255) not null,
  constraint pk_roles primary key (id)
);

create table routes (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  name_route                    varchar(255) not null,
  description_route             varchar(255) not null,
  route_type                    integer not null,
  status_route                  integer not null,
  constraint pk_routes primary key (id)
);

create table route_tags (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  id_route                      integer not null,
  id_tag                        integer not null,
  constraint pk_route_tags primary key (id)
);

create table tags (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  name_tag                      varchar(255) not null,
  description_tag               varchar(255) not null,
  constraint pk_tags primary key (id)
);

create table tag_roles (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  id_role                       integer not null,
  id_tag                        integer not null,
  constraint pk_tag_roles primary key (id)
);

create table users (
  id                            integer auto_increment not null,
  created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  id_role                       integer not null,
  id_partner                    integer not null,
  name_user                     varchar(255) not null,
  last_name_user                varchar(255) not null,
  pass_user                     varchar(255) not null,
  last_date_login_user          datetime(6) not null,
  status_user                   integer not null,
  constraint pk_users primary key (id)
);


# --- !Downs

drop table if exists cities;

drop table if exists configs;

drop table if exists countries;

drop table if exists creditcard_tokens;

drop table if exists customers;

drop table if exists customer_has_extradata;

drop table if exists customer_has_plans;

drop table if exists frecuencies;

drop table if exists invoices;

drop table if exists invoice_lines;

drop table if exists partners;

drop table if exists payments;

drop table if exists plans;

drop table if exists roles;

drop table if exists routes;

drop table if exists route_tags;

drop table if exists tags;

drop table if exists tag_roles;

drop table if exists users;

