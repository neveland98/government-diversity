import { Person } from './Person';

export interface Term{
    termId: number;
    person: Person;
    termStart: number;
    termEnd: number;
    year: number;
    region: string;
    position: string;
    party: String;
}